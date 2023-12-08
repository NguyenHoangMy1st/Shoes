package com.dnanh01.backend.request;

public class ReviewRequest {

    private Long productId;
    
    private Long rating;

    private String review;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}
