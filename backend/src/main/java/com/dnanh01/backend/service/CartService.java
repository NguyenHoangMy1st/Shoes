package com.dnanh01.backend.service;

import com.dnanh01.backend.exception.CartItemException;
import com.dnanh01.backend.exception.ProductException;
import com.dnanh01.backend.exception.UserException;
import com.dnanh01.backend.model.Cart;
import com.dnanh01.backend.model.User;
import com.dnanh01.backend.request.AddItemRequest;

public interface CartService {
    public Cart createCart(User user);

    public String addCartItem(Long userId, AddItemRequest req)
            throws ProductException, CartItemException, UserException;

    public Cart findUserCart(Long userId);
}
