package model;

public class Fruit {
    private int iD;
    private String name;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(int iD, String name, double price, int quantity, String origin) {
        this.iD = iD;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
