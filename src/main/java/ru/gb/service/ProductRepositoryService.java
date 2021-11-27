package ru.gb.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.gb.entity.Product;
import ru.gb.repository.ProductRepository;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductRepositoryService implements ProductRepository {

    private List<Product> productMap;
    private int ID = 0;

    @PostConstruct
    void init() {
        productMap = new ArrayList<>();
        productMap.add( new Product(++ID, "title1", "1"));
        productMap.add( new Product(++ID, "title2", "2"));
        productMap.add( new Product(++ID, "title3", "3"));
        productMap.add( new Product(++ID, "title4", "4"));
        productMap.add( new Product(++ID, "title5", "5"));

    }


    @Override
    public List<Product> getAll() {
        return productMap;
    }

    @Override
    public Product findById(Integer id) {
        try {
            return productMap.get(id);
        } catch (NoSuchElementException e) {
            System.out.println("not found product");
        }return  null;
    }

    @Override
    public void addProduct(Product product) {
        product.setId(++ID);
        productMap.add(product);
    }
}
