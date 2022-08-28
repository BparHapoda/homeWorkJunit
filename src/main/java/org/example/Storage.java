package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Storage {
    private ArrayList <Item> storage = new ArrayList<>();

    public void add (Item item){
        storage.add(item);
    }
    public void save (){
        File file = new File("storage.db");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try
                (FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos))
        {

            oos.writeObject(storage);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean storageIs (){
        File file = new File("storage.db");
        if (!file.exists()){
            return false;
        }
        return true;
    }
    public ArrayList <Item> load(){
        ArrayList <Item> storage = new ArrayList<>();
        File file = new File("storage.db");
        try
                (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream oos = new ObjectInputStream(fis))
        {
            storage= (ArrayList<Item>) oos.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return storage;
    }

    public void printStorage (){
        if(storage.size()==0){System.out.println("Общий список товаров пуст");}
        else {
            storage.forEach(System.out::println);
        }
    }

    public ArrayList<Item> getStorage() {
        return storage;
    }

    public void setStorage(ArrayList<Item> storage) {
        this.storage = storage;
    }
    public int [] generateBarcode (){
        int [] barcode = new int [13];
        if (storage.size()==0){return barcode;}
        int code =storage.size();
        for (int i = 0; i < barcode.length; i++) {
            barcode[i] = code % 10;
            code = code / 10;}

        return barcode;
    }
public int getItemNumberByBarcode (int [] barcode){
        for (int i=0;i<storage.size();i++){if(Arrays.equals(storage.get(i).getBarcode(), barcode))
        {return i;}
        }
        return -1;
}

}
