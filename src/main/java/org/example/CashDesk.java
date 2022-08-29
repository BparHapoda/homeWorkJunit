package org.example;

public class CashDesk {
    private Storage storage;
    private Basket basket;

    public CashDesk (Storage storage){
        if (storage.getStorage().size()==0){throw new IllegalArgumentException("Таблица баркодов пуста");}
        this.storage=storage;
    }

    public void createBasket (){
        basket=new Basket();
    }

    public Basket getBasket() {
        return basket;
    }
}
