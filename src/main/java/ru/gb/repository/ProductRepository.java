package ru.gb.repository;

import ru.gb.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {

    List<Product> getAll();

    Product findById(Integer id);

    void addProduct(Product product);


}
