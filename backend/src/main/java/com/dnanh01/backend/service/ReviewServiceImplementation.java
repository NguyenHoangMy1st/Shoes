package com.dnanh01.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dnanh01.backend.exception.ProductException;
import com.dnanh01.backend.model.Product;
import com.dnanh01.backend.model.Review;
import com.dnanh01.backend.model.User;
import com.dnanh01.backend.repository.ProductRepository;
import com.dnanh01.backend.repository.ReviewRepository;
import com.dnanh01.backend.request.ReviewRequest;

@Service
public class ReviewServiceImplementation implements ReviewService {

    private ReviewRepository reviewRepository;
    private ProductService productService;
    private ProductRepository productRepository;

    public ReviewServiceImplementation(
            ReviewRepository reviewRepository,
            ProductService productService,
            ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());
        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setRating(req.getRating());
        review.setCreateAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviews(Long productId) {
        return reviewRepository.getAllProductsReview(productId);
    }

}
