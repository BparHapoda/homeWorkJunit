package org.example;

public class Product {
    private Item item;
    private double quantity;

    private double price;

    public Product (Item item,double quantity){
        this.item=item;
        this.quantity=quantity;
        this.price=item.getUnitPrice()*quantity;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Product{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }
}
