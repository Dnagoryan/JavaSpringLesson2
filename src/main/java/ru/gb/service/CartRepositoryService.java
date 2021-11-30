package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.gb.entity.Product;
import ru.gb.repository.CartRepository;
import ru.gb.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartRepositoryService implements CartRepository {


    private List<Product> cart;
    @Autowired
    private  ProductRepository repository;


    @PostConstruct
    public  void init(){
        cart= new ArrayList<>();
    }

    @Override
    public void putProductById(Integer id) {
        cart.add(repository.findById(id));

    }

    @Override
    public List<Product> getAllProduct() {
        return cart;
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = repository.findById(id);
        //            int index = cart.indexOf(product);
        //            String quantity = cart.get(index).getQuantity();
        //            if (quantity >= 2) {
        //                cart.get(index).setQuantity(quantity-1);
        //            }else {
        cart.remove(product);
        }
    }

