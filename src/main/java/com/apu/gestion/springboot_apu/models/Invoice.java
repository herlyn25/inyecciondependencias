package com.apu.gestion.springboot_apu.models;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;

@Component
@SessionScope
@JsonIgnoreProperties({"targetSource","advisors"})
public class Invoice {
    @Autowired
    private Client client;
    
    @Value("${invoice.description}")
    private String description;
    
    @Autowired
    private List<Item> items;

    @PostConstruct
    public void init(){
        client.setName(client.getName().concat(" de Jesus"));
        client.setLastname(client.getLastname().concat(" Castilla"));
        description =  description.concat(" del cliente ").concat(client.getName()).concat(" ").concat(client.getLastname());
    }
    
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public int getTotal(){
        int total= items.stream()
        .map(item->item.getImporte())
        .reduce(0, (sum,importe)->sum+importe);
        return total;
    }
}