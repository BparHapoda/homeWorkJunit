package org.example;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 6282014612437626445L;
    private String name;
    private double unitPrice;
    private String unitName;
    private int [] barcode;
    private ArrayList <Offer> offers;

    public Item(String name,double unitPrice,String unitName,int [] barcode,ArrayList <Offer> offer){
this.name=name;
if(name.length()<3 || name.length()>20){throw new IllegalArgumentException
        ("Длина имени должна быть больше 3 и меньше 250");};
this.unitPrice=unitPrice;
if (unitPrice<0.01 || unitPrice<0){throw new IllegalArgumentException("Цена единицы" +
        "товара не может быть меньше 0.01 или отрицательной");}
this.unitName=unitName;
        if(unitName.length()<2 || unitName.length()>5){throw new IllegalArgumentException
                ("Длина cокращенного названия должна быть от 2 до 5 символов");};
this.barcode=barcode;
        if(barcode.length!=13){throw new IllegalArgumentException
                ("Баркод должен состоять из 13 символов");};

this.offers=offer;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitName='" + unitName + '\'' +
                ", barcode=" + Arrays.toString(barcode) +
                ", offers=" + offers +
                '}';
    }

    public int[] getBarcode() {
        return barcode;
    }
}
