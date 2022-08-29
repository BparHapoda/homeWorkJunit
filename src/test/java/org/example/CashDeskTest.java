package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashDeskTest {
    private final Storage storage=new Storage();
    private final int [] barcode={1};

    CashDeskTest() {
    }

    @Test
    public void ifStorageSizeIsNullShouldThrowException (){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new CashDesk(storage));
    }

    @Test
    public void barcodeListShouldBeNotNull() {
        Assertions.assertTrue(barcode.length>0);
    }
}