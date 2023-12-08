package com.dnanh01.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnanh01.backend.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
