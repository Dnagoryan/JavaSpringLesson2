package ru.gb.repository;

import ru.gb.entity.Product;

import java.util.List;


public interface CartRepository {

    void putProductById(Integer id);

    List<Product> getAllProduct();

    void deleteProduct(Integer id);


}
