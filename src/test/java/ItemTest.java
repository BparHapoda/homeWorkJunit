import org.example.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


class ItemTest {
    Item item = Mockito.mock(Item.class);


@Test
    void sell(){
    int g=6;
    Assertions.assertEquals(0,g);
}
}
