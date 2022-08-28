import org.example.Item;
import org.example.Offer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class ItemTest {
    private static final String NAME_2="01";
    private static final String NAME_50="01234567890123456789012345678901234567890123456789";
    private static final String NAME_100=NAME_50+NAME_50;
    private static final String NAME_251=NAME_100+NAME_100+NAME_50+"1";

    private final int barcode13 [] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private final int barcode14 [] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13};
    private final ArrayList<Offer> offers = new ArrayList<>();

    private static final double unitPrice =0.0005;
    private static final double unitPriceNegative =-1.00;
    private static final double goodUnitPrice =1.5;

private Item item;

    @Test
        public void itemNameOver250ShouldThrowException () {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new Item(NAME_251,goodUnitPrice,"1", barcode13,
                offers));
        }

    @Test
    public void itemNameLess3ShouldThrowException () {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new Item(NAME_2,
                goodUnitPrice, "1", barcode13, offers));
    }

    @Test
    public void itemPriceLess001ShouldThrowException (){
        Assertions.assertThrows(IllegalArgumentException.class,()->
                new Item(NAME_100,goodUnitPrice,"1",barcode13,offers));
    }
    @Test
    public void itemPriceNegativeShouldThrowException (){
        Assertions.assertThrows(IllegalArgumentException.class,()->
                new Item(NAME_100,goodUnitPrice,"1",barcode13,offers));
    }
    @Test
    public void unitPriceless0005ShouldThrowException (){
        Assertions.assertThrows(IllegalArgumentException.class,()->
                new Item(NAME_100,unitPrice,"1",barcode13,offers));
    }
    @Test
    public void unitPriceNegativeShouldThrowException (){
        Assertions.assertThrows(IllegalArgumentException.class,()->
                new Item(NAME_100,unitPriceNegative,"1",barcode13,offers));
    }
   }

