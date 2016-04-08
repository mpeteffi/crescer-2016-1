

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class InventarioTest
{
     
    @Test
    public void testeItemAdicionado(){
        Item i1 = new Item(1,"Martelo");
        Inventario bolsa = new Inventario();
        bolsa.adicionarItem(i1);
        assertEquals(i1,bolsa.getItem().get(0));
    }
    
    @Test
    public void testeRemoverDaLista(){
        Item i1 = new Item(1,"Martelo");
        Inventario bolsa = new Inventario();
        bolsa.adicionarItem(i1);
        assertTrue(bolsa.getItem().get(0)==i1);
        bolsa.removerItem(i1);
        assertTrue(bolsa.getItem().size()==0);
    }
    
}
