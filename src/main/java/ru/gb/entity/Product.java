package ru.gb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope("prototype")
@AllArgsConstructor
@Data
public class Product {

    Integer id;
    String title;
    int price;
    int quantity;


}
