package org.example;

public class CashDesk {
    private Storage storage;

    public CashDesk (Storage storage){
        if (storage.getStorage().size()==0){throw new IllegalArgumentException("Таблица баркодов пуста");}
        this.storage=storage;
    }

}
