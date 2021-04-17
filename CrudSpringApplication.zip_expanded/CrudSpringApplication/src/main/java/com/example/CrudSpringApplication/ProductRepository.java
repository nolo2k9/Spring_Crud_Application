package com.example.CrudSpringApplication;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Type of the id field in the product class
 * Jpa repository already defines vital methods needed for this application such as findAll(), findById(). 
 */
public interface ProductRepository extends JpaRepository<Product, Long>{

}
