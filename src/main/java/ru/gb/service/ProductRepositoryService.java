package ru.gb.service;

import org.springframework.stereotype.Component;
import ru.gb.entity.Product;
import ru.gb.repository.ProductRepository;


import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRepositoryService implements ProductRepository {

    private Map<Integer, Product> productMap;
    private int ID = 0;

    @PostConstruct
    void init() {
        productMap = new ConcurrentHashMap<>();
        productMap.put(++ID, new Product(ID, "title1", 1, 1));
        productMap.put(++ID, new Product(ID, "title2", 2, 1));
        productMap.put(++ID, new Product(ID, "title3", 3, 1));
        productMap.put(++ID, new Product(ID, "title4", 4, 1));
        productMap.put(++ID, new Product(ID, "title5", 5, 1));

    }


    @Override
    public Map<Integer, Product> getAll() {
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
        productMap.put(ID++,product);
    }
}
