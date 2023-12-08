package com.dnanh01.backend.service;

import com.dnanh01.backend.exception.UserException;
import com.dnanh01.backend.model.User;

public interface UserService {

    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;

    public User getUserByEmail(String email) throws UserException;
}