package com.demotxt.myapp.myapplication.model;

/**
 * Created by Aws on 11/03/2018.
 */

public class PizzaDetails {

    private Integer pizzaId;
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
    public PizzaDetails() {
    }

    public PizzaDetails(Integer pizzaId, String name, String description, Integer price, String imageUrl) {
        this.pizzaId = pizzaId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
