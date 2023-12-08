package com.dnanh01.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dnanh01.backend.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query("SELECT br FROM Brand br " +
            "WHERE br.name = :name")
    public Brand findSingleBrandByName(
            @Param("name") String name);
}