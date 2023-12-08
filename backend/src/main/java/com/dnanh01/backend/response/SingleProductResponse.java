package com.dnanh01.backend.response;

public class SingleProductResponse {
    private String title;

    private String imageUrl;

    private int price;

    private int numRatings;

    public SingleProductResponse() {
    }

    public SingleProductResponse(String title, String imageUrl, int price, int numRatings) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.price = price;
        this.numRatings = numRatings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

}
