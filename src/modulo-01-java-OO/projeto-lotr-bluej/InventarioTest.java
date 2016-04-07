

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class InventarioTest
{
     
    
    @Test
    public void testeItemAdicionado(){
        Item i1 = new Item(1,"Martelo");
        Inventario bolsa = new Inventario();
        bolsa.adicionarItem(i1);
        assertEquals(i1,bolsa.getItem(i1));
    }
    
    @Test
    public void testeDescricaoAdicionadaIgualDescricaoNaLista(){
        Item i1 = new Item(1,"Martelo");
        Inventario bolsa = new Inventario();
        bolsa.adicionarItem(i1);
        assertEquals("Martelo",bolsa.getItem(i1).getDescricao());
    }
    
    @Test
    public void testeProcurarNaLista(){
        Item i1 = new Item(1,"Martelo");
        Item i2 = new Item(1,"Machado");
        Inventario bolsa = new Inventario();
        bolsa.adicionarItem(i1);
        bolsa.adicionarItem(i2);
        assertEquals(0,bolsa.procurarItemNaLista(i1));
        assertEquals(1,bolsa.procurarItemNaLista(i2));       
    }
    
    @Test
    public void testeRemoverDaLista(){
        Item i1 = new Item(1,"Martelo");
        Inventario bolsa = new Inventario();
        bolsa.adicionarItem(i1);
        assertEquals(0,bolsa.procurarItemNaLista(i1));
        bolsa.removerItem(i1);
        assertEquals(-1,bolsa.procurarItemNaLista(i1));
    }
    
}
