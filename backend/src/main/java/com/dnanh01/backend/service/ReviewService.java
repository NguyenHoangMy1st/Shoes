package com.dnanh01.backend.service;

import java.util.List;

import com.dnanh01.backend.exception.ProductException;
import com.dnanh01.backend.model.Review;
import com.dnanh01.backend.model.User;
import com.dnanh01.backend.request.ReviewRequest;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user) throws ProductException;

    public List<Review> getAllReviews(Long productId);
}
