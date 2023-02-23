package com.food.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.FoodApp.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}