package org.example;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Basket {
    private ArrayList<Product> products=new ArrayList<>();


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void add (Item item,double quantity){
products.add(new Product(item,quantity));
    }
    public double sumBasket (ArrayList <Product> products){
     double sum=0;
     sum =products.stream().mapToDouble(Product::getPrice).sum();
     return sum;
    }

    public String checkout (){

        ArrayList <Product> offer31 = new ArrayList<>();
        ArrayList <Product> offer2503100 =new ArrayList<>();
        ArrayList <Product> offerPercent = new ArrayList<>();
        ArrayList <Product> offerNo = new ArrayList<>();

        for(Product product:products){
            if (product.getItem().getOffer()==Offer.NO_OFFER){offerNo.add(product);}
            else if (product.getItem().getOffer()==Offer.OFFER_31) {
             offer31.add(product);
            } else if (product.getItem().getOffer()==Offer.OFFER_2_50_3_100) {
            offer2503100.add(product)   ;
            } else if (product.getItem().getOffer()==Offer.OFFER_PERCENT) {
              offerPercent.add(product);
            }
        }

        double sum =0;

        double sumNoOffer =0;
        for (Product product:offerNo){
          sumNoOffer +=  product.getQuantity()*product.getItem().getUnitPrice();
        }

        double sumPercent =0;
        for (Product product:offerPercent){
            sumPercent +=  (product.getQuantity()*product.getItem().getUnitPrice())*0.8;
        }

        double sum31 =0;

        ArrayList <Product> sorted =new ArrayList<>();
       sorted= (ArrayList<Product>) offer31.stream().
               sorted((x, y)-> x.getItem().getName().compareTo
                       (y.getItem().getName())).collect(Collectors.toList());
       int count =1;
for (int i=0;i<sorted.size()-1;i++){
  if (sorted.get(i+1).getItem().equals(sorted.get(i).getItem())) {count++;
  if (count==3){sorted.get(i).setPrice(0.01);count=0;}
  }
  sum31=sumBasket(sorted);
}


System.out.println(sumNoOffer);
        System.out.println(sumPercent);
        System.out.println(sum31);


return products.toString();
    }
}
