

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
    
    @Test
    public void ImprimirTodasDescricoesDeItens(){
        Dwarf d1 = new Dwarf("Legolas");
        Item i1 = new Item(1,"Martelo");
        Item i2 = new Item(1,"Machado");
        Item i3 = new Item(1,"Escudo");
        d1.adicionarItem(i1);
        d1.adicionarItem(i2);
        d1.adicionarItem(i3);
        assertEquals("Martelo,Machado,Escudo",d1.getInventario().getDescricoesItens());
    }
    
    @Test
    public void retornaItemMaisPopularMaca(){
        Dwarf d1 = new Dwarf("Legolas");
        Item i1 = new Item(2,"Martelo");
        Item i2 = new Item(18,"Machado");
        Item i3 = new Item(12,"Escudo");
        Item i4 = new Item(333,"Maças");
        d1.adicionarItem(i1);
        d1.adicionarItem(i2);
        d1.adicionarItem(i3);
        d1.adicionarItem(i4);
        assertEquals(d1.getInventario().itemMaisPopular(),i4); 
    }
    
    @Test
    public void ordenarItensCrescente4Itens(){
        Dwarf d1 = new Dwarf("Legolas");
        Item i1 = new Item(2,"Martelo");
        Item i2 = new Item(18,"Machado");
        Item i3 = new Item(12,"Escudo");
        Item i4 = new Item(1,"Maças");
        d1.adicionarItem(i1);
        d1.adicionarItem(i2);
        d1.adicionarItem(i3);
        d1.adicionarItem(i4);
        d1.getInventario().ordenarItens();
        assertTrue(d1.getInventario().getItem().get(0).getQuantidade()==1);
        assertTrue(d1.getInventario().getItem().get(1).getQuantidade()==2);
        assertTrue(d1.getInventario().getItem().get(2).getQuantidade()==12);
        assertTrue(d1.getInventario().getItem().get(3).getQuantidade()==18);
    }
    
    @Test
    public void ordenarItensCrescente5Itens(){
        Dwarf d1 = new Dwarf("Legolas");
        Item i1 = new Item(90,"Martelo");
        Item i2 = new Item(13,"Machado");
        Item i3 = new Item(12,"Escudo");
        Item i4 = new Item(5,"Maças");
        Item i5 = new Item(8,"Flechas");
        d1.adicionarItem(i1);
        d1.adicionarItem(i2);
        d1.adicionarItem(i3);
        d1.adicionarItem(i4);
        d1.adicionarItem(i5);
        d1.getInventario().ordenarItens();
        assertTrue(d1.getInventario().getItem().get(0).getQuantidade()==5);
        assertTrue(d1.getInventario().getItem().get(1).getQuantidade()==8);
        assertTrue(d1.getInventario().getItem().get(2).getQuantidade()==12);
        assertTrue(d1.getInventario().getItem().get(3).getQuantidade()==13);
        assertTrue(d1.getInventario().getItem().get(4).getQuantidade()==90);
        
    }
}
