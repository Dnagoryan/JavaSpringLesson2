package ru.gb.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.entity.Product;
import ru.gb.service.CartRepositoryService;
import ru.gb.service.ProductRepositoryService;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepositoryService productService;



    //создание новой корзины
    @RequestMapping(value = "/create", method = RequestMethod.GET )
    public String getAllProduct(Model model){
        model.addAttribute("products", productService.getAll());
        return "main-menu";
    }


    //метод создания формы
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showSimpleForm(Product product){
        productService.addProduct(product);
        return "add-product";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String showSimpleForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "main-menu";
    }
}
