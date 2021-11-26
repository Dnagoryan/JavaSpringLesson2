package ru.gb.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.gb.repository.CartRepository;
import ru.gb.repository.ProductRepository;
import ru.gb.service.CartRepositoryService;
import ru.gb.service.ProductRepositoryService;

@Configuration
@ComponentScan("ru.gb")
public class ApplicationConfig {

    @Bean
    @Scope (value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CartRepository cartRepositoryService(){
        return new CartRepositoryService();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ProductRepository productRepositoryService(){
        return new ProductRepositoryService();
    }

}
