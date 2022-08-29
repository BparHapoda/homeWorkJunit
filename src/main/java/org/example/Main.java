        package org.example;

        import static org.example.Offer.*;
        import static org.example.Units.*;

        /*
        Для каждого задания необходимо подготовить список
        kata и решить задания методом TDD, т. е. cначала написать юнит-тесты, потом код.
        Супермаркету необходимо написать программу для
        кассового места.
        В супермаркете есть различные товары, каждый товар
        имеет такие характеристики:
        ? наименование товара;
        ? цена за одну единицу измерения в гривнах и копейках;
        ? единица измерения (штука, килограммы, граммы, литры);
        ? номер штрих кода;
        ? тип акции.
        Наименование товара – название изделия, минимальная
        длина три символа, максимальная длина 250 символов.
        Цена за единицу – минимальная цена товара 0.01 гривны,
        максимальная не ограничена. Цена должна быть всегда положительной.
        Единица измерения – сокращенное название, длина не
        менее 2 символов и не более 5.
        Номер штрих-кода – длина штрих-кода должна быть
        всегда 13 цифр. Может иметь нули в начале номера.
        Типа акции – товар может участвовать или не участвовать в акциях супермаркета. В супермаркете есть несколько
        видов акций:
        ? каждый третий купленный товар, участвующий в данной
        акции продается бесплатно (за 1 копейку);
        ? на второй товар, участвующий в этой акции, 50% скидка,
        на третий товар – 100% скидка. Скидка должна даваться на
        самый дешевый товар из чека. Дается только одна скидка.
        Т.е. если куплено три акционных товара, два более дорогих
        идут по полной цене, третий – наиболее дешевый – по 1
        копейке.
        ? сезонная скидка на товар – действует в определенный
        период, указывается в процентах.
        Программа должна уметь:
        ? считывая номера штрих-кодов товаров, вносить их в
        корзину покупок;
        ? рассчитывать общую сумму по чеку, учитывая скидки на
        акционные товары.
         */
public class Main {
    public static void main(String[] args) {
Storage storage = new Storage();
if (storage.storageIs()){
    storage.setStorage(storage.load());}
else  {createStorage(storage);}
CashDesk cashDesk = new CashDesk(storage);
        int barcode1 [] ={1,0,0,0,0,0,0,0,0,0,0,0,0};
        int barcode2 [] ={2,0,0,0,0,0,0,0,0,0,0,0,0};
        int barcode3 [] ={3,0,0,0,0,0,0,0,0,0,0,0,0};
        int barcode4 [] ={4,0,0,0,0,0,0,0,0,0,0,0,0};
        int barcode5 [] ={5,0,0,0,0,0,0,0,0,0,0,0,0};
        int barcode6 [] ={6,0,0,0,0,0,0,0,0,0,0,0,0};




        cashDesk.createBasket();
      cashDesk.getBasket().add(storage.getItemByBarcode(barcode6),1.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode1),1.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode2),2.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode1),1.5);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode2),1.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode2),1.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode2),1.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode3),1.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode3),1.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode3),1.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode4),1.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode5),1.0);
        cashDesk.getBasket().add(storage.getItemByBarcode(barcode6),1.0);


        System.out.println("Сумма чека : "+cashDesk.getBasket().checkout());


    }
    public static void createStorage(Storage storage){
       storage.add(new Item("огурцы",10.5, KG, storage.generateBarcode(), OFFER_2_50_3_100));
        storage.add(new Item("помидоры",1.9, KG, storage.generateBarcode(), OFFER_PERCENT));
        storage.add(new Item("ананас",1.0, PIECE, storage.generateBarcode(), OFFER_31));
        storage.add(new Item("хрен",110.5, KG, storage.generateBarcode(), NO_OFFER));
        storage.add(new Item("корица",1110.5, GRAMM, storage.generateBarcode(), NO_OFFER));
        storage.add(new Item("молоко",11.5, LITER, storage.generateBarcode(), OFFER_2_50_3_100));
        storage.save();

    }
}