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
}
