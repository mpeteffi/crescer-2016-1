import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void equalsItem1EItem2(){
        Item item1 = new Item(1,"Machado");
        Item item2 = new Item(1,"Machado");
        assertEquals(item1,item2);
        assertTrue(item1.equals(item2));
    }
    
    @Test
    public void notEqualsItem1eItem2(){
        Item item1 = new Item(1,"Machado");
        Item item2 = new Item(2,"Machado");
        assertFalse(item1.equals(item2));
    }
}
