package com.niit.domain;

public class Fruit {
    private String name;  //水果名
    private double price;

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", producing_area='" + producing_area + '\'' +
                '}';
    }

    public Fruit(String name, double price, String producing_area) {
        this.name = name;
        this.price = price;
        this.producing_area = producing_area;
    }

    //价格
    private String producing_area;//产地

    public Fruit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducing_area() {
        return producing_area;
    }

    public void setProducing_area(String producing_area) {
        this.producing_area = producing_area;
    }
}
