package com.apu.gestion.springboot_apu;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.apu.gestion.springboot_apu.models.Item;
import com.apu.gestion.springboot_apu.models.Product;


@Configuration
@PropertySource(value = "classpath:data.properties")
public class Appconfig {
    
    @Bean
    List<Item> itemInvoice(){
        Product p1= new Product("camara Sony", 800);
        Product p2= new Product("Bici Alhua", 1800);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @SuppressWarnings("null")
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // aplica para todas las rutas
                        .allowedOrigins("http://localhost:5173") // frontend origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}
