package ru.gb.client;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.ApplicationConfig;

public class GoToShop {
    public static void main(String[] args) {
      AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        System.out.println("context setup: " + context.getApplicationName());
    }


}
