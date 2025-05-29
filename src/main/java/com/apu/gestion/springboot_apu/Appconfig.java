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
        Product p1= new Product("Camara Sony", 800);
        Product p2= new Product("Bici Alhua", 1800);
        Product p3= new Product("Ipad",600);
        Product p4= new Product("SmartWatch",600);
        return Arrays.asList(new Item(p1, 5), new Item(p2, 4), new Item(p3,6), new Item(p4,5));
    }

        @Bean
        @Primary
    List<Item> itemInvoiceBussiness(){
        Product p1= new Product("Notebook Razer", 1800);
        Product p2= new Product("Chairs", 400);
        Product p3= new Product("Mac",3600);
        Product p4= new Product("Desktop",900);
        return Arrays.asList(new Item(p1, 5), new Item(p2, 4), new Item(p3,6), new Item(p4,5));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @SuppressWarnings("null")
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // aplica para todas las rutas
                        .allowedOrigins("*") // frontend origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}
