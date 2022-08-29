package org.example;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 6282014612437626445L;
    private String name;
    private double unitPrice;
    private Units unit;
    private int [] barcode;
    private Offer offer;


    public Item(String name, double unitPrice, Units unit, int [] barcode, Offer offer){
this.name=name;
if(name.length()<3 || name.length()>20){throw new IllegalArgumentException
        ("Длина имени должна быть больше 3 и меньше 250");};
this.unitPrice=unitPrice;
if (unitPrice<0.01 || unitPrice<0){throw new IllegalArgumentException("Цена единицы" +
        "товара не может быть меньше 0.01 или отрицательной");}
this.unit=unit;
        if(unit.name().length()<2 || unit.name().length()>5){throw new IllegalArgumentException
                ("Длина cокращенного названия должна быть от 2 до 5 символов");};
this.barcode=barcode;
        if(barcode.length!=13){throw new IllegalArgumentException
                ("Баркод должен состоять из 13 символов");};
this.offer=offer;


    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name +
                ", barcode=" + Arrays.toString(barcode) +
                ", offers=" + offer +
                '}';
    }

    public Offer getOffer() {
        return offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.unitPrice, unitPrice) == 0 && Objects.equals(name, item.name) && unit == item.unit && Arrays.equals(barcode, item.barcode) && offer == item.offer;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, unitPrice, unit, offer);
        result = 31 * result + Arrays.hashCode(barcode);
        return result;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    public int[] getBarcode() {
        return barcode;
    }
}
