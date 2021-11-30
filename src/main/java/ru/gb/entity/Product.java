package ru.gb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope("prototype")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {

    Integer id;
    String title;
    String price;
//    String quantity;





}
