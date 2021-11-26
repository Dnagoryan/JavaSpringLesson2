package ru.gb.client;

import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.ApplicationConfig;
import ru.gb.entity.Product;
import ru.gb.repository.ProductRepository;
import ru.gb.service.CartRepositoryService;
import ru.gb.service.ProductRepositoryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Client {

    private ApplicationContext context;
    private CartRepositoryService cart;
    private String console;
    private BufferedReader reader;


    public Client() {
        context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        System.out.println("context setup: " + context.getApplicationName());

        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startClient() {
        System.out.println("Для отображения команд введите -help");
        try {
            console = reader.readLine();
            while (!console.equals("-end")) {
                switch (console) {
                    case "-add":
                        addProduct();
                        break;
                    case "-delete":
                        removeProduct();
                        break;
                    case "-showCart":
                        showCart();
                        break;
                    case "-help":
                        showHelp();
                        break;
                    case "-create":
                        createdCart();
                        break;
                    case "-showProduct":
                        showProduct();
                        break;
                }
                console = reader.readLine();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private void showProduct() {
        val map = context.getBean(ProductRepository.class).getAll();
        for (Product p : map.values()) {

            System.out.println(p);
        }
    }

    private void showCart() {
        if (cart == null){
            System.out.println("Корзина не создана");
            return;}
        if (cart.getAllProduct().size() == 0) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("В коризне: ");
            for (Product p : cart.getAllProduct()) {
                System.out.println(p);
            }
        }
    }

    private void createdCart() {
        cart = context.getBean("cartRepositoryService", CartRepositoryService.class);
        System.out.println("Успешно создали новую корзину");
        showCart();
    }


    private void showHelp() {
        System.out.println("Для вызова списка комманд введите -help \n\r" +
                "Для инициализации новой корзины товаров введите -create \n\r" +
                "Для получения списка товаров в корзине введите -showCart \n\r" +
                "Для получения списка доступных товаров введите -showProduct \n\r" +
                "Для добавления товара в корзину введите -add \n\r" +
                "Для удаления товара из корзины введите -delete \n\r" +
                "Для выхода введите -end \n\r");
    }


    private void removeProduct() {
        System.out.print("Введите ID товара для удаления из корзины: ");
        try {
            int id = Integer.parseInt(reader.readLine());
            cart.deleteProduct(id);
            showCart();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Ошибка! Заданный ID не существует");
        }
    }


    private void addProduct() {
        System.out.print("Введите ID товара: ");
        try {
            int id = Integer.parseInt(reader.readLine());
            cart.putProductById(id);
            showCart();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Ошибка! Заданный ID не существует");
        } catch (NullPointerException n) {
            System.out.println("Ошибка! Создайте корзину");
        }

    }
}





