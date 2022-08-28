package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashDeskTest {
    private final Storage storage=new Storage();

    @Test
    public void ifStorageSizeIsNullShouldThrowException (){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new CashDesk(storage));
    }

}