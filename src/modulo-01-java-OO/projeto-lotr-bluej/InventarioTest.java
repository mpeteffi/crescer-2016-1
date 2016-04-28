

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.ArrayList;


public class InventarioTest
{
    @Test
    public void getDescricoesItensVazio() {
        Inventario inventario = new Inventario();
        String obtido = inventario.getDescricoesItens();
        assertEquals("", obtido);
    }    
    
    @Test
    public void itemAdicionado(){
        Item i1 = new Item(1,"Martelo");
        Inventario bolsa = new Inventario();
        bolsa.adicionarItem(i1);
        assertEquals(i1,bolsa.getLista().get(0));
    }
    
    @Test
    public void removerDaLista(){
        Item i1 = new Item(1,"Martelo");
        Inventario bolsa = new Inventario();
        bolsa.adicionarItem(i1);
        assertTrue(bolsa.getLista().get(0)==i1);
        bolsa.removerItem(i1);
        assertTrue(bolsa.getLista().size()==0);
    }
    
    @Test
    public void imprimirTodasDescricoesDeItens(){
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
        assertTrue(d1.getInventario().getLista().get(0).getQuantidade()==1);
        assertTrue(d1.getInventario().getLista().get(1).getQuantidade()==2);
        assertTrue(d1.getInventario().getLista().get(2).getQuantidade()==12);
        assertTrue(d1.getInventario().getLista().get(3).getQuantidade()==18);
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
        assertTrue(d1.getInventario().getLista().get(0).getQuantidade()==5);
        assertTrue(d1.getInventario().getLista().get(1).getQuantidade()==8);
        assertTrue(d1.getInventario().getLista().get(2).getQuantidade()==12);
        assertTrue(d1.getInventario().getLista().get(3).getQuantidade()==13);
        assertTrue(d1.getInventario().getLista().get(4).getQuantidade()==90);
        
    }
    
    @Test
    public void equalsInventariosMesmosItensEPosicoesIguais(){
        Inventario bolsa1 = new Inventario();
        Inventario bolsa2 = new Inventario();
        Item i1 = new Item(2,"Martelo");
        Item i2 = new Item(2,"Martelo");
        Item i3 = new Item(1,"Machado");
        Item i4 = new Item(1,"Machado");
        bolsa1.adicionarItem(i1);
        bolsa2.adicionarItem(i2);
        bolsa1.adicionarItem(i3);
        bolsa2.adicionarItem(i4);
        assertTrue(bolsa1.equals(bolsa2));
    }
    
    @Test
    public void equalsInventariosMesmosItensEPosicoesDiferentes(){
        Inventario bolsa1 = new Inventario();
        Inventario bolsa2 = new Inventario();
        Item i1 = new Item(2,"Martelo");
        Item i2 = new Item(2,"Martelo");
        Item i3 = new Item(1,"Machado");
        Item i4 = new Item(1,"Machado");
        bolsa1.adicionarItem(i1);
        bolsa1.adicionarItem(i3);
        bolsa2.adicionarItem(i4);
        bolsa2.adicionarItem(i2);
        assertTrue(bolsa1.equals(bolsa2));
    }
    
    @Test
    public void equalsInventariosItensDiferenteseRepetidos(){
        Inventario bolsa1 = new Inventario();
        Inventario bolsa2 = new Inventario();
        Item i1 = new Item(2,"Martelo");
        Item i2 = new Item(1,"Machado");
        Item i3 = new Item(1,"Machado");
        Item i4 = new Item(1,"Machado");
        bolsa1.adicionarItem(i2);
        bolsa1.adicionarItem(i3);
        bolsa2.adicionarItem(i4);
        bolsa2.adicionarItem(i1);
        assertFalse(bolsa1.equals(bolsa2));
        bolsa1.adicionarItem(i1);
        bolsa2.adicionarItem(i2);
        assertTrue(bolsa1.equals(bolsa2));
    }
}
