package ru.gb.repository;

import ru.gb.entity.Product;

import java.util.Map;

public interface ProductRepository {

    Map<Integer, Product>  getAll();

    Product findById(Integer id);

    void addProduct(Product product);


}
