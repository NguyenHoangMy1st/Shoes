package com.dnanh01.backend.service;

import com.dnanh01.backend.exception.ProductException;
import com.dnanh01.backend.model.Brand;

public interface BrandService {
    public Brand getAllBrands() throws ProductException;
}
