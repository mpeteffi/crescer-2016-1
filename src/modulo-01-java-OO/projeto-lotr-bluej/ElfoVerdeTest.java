

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    
    @Test
    public void ganhaDobroDeExperiencia(){
        Elfo branco = new Elfo("Branco");
        Elfo verde = new ElfoVerde("Verde");
        branco.atirarFlecha(new Dwarf("gimli"));
        verde.atirarFlecha(new Dwarf("gimli"));
        assertEquals(branco.getExperiencia(),1);
        assertEquals(verde.getExperiencia(),2); 
        branco.atirarFlecha(new Dwarf("gimli"));
        verde.atirarFlecha(new Dwarf("gimli"));
        assertEquals(branco.getExperiencia(),2);
        assertEquals(verde.getExperiencia(),4); 
    }
    
    @Test
    public void adicionaItensApenasComDescricaoEspecifica(){
        Elfo verde = new ElfoVerde("Verde");
        Item i1 = new Item(3,"Machado");
        Item i2 = new Item(5,"Espada de aço valiriano");
        Item i3 = new Item(6,"Maça");
        Item i4 = new Item(2,"Arco e Flecha de Vidro");
        verde.adicionarItem(i1);
        verde.adicionarItem(i2);
        verde.adicionarItem(i3);
        verde.adicionarItem(i4);
        assertEquals(verde.getInventario().getLista().size(),2);
        assertEquals(verde.getInventario().getLista().get(0),i2);
        assertEquals(verde.getInventario().getLista().get(1),i4);
    }
    
    @Test 
    public void elfoVerdeNasceCom100DeVida(){
        Elfo verde = new ElfoVerde("Legolas");
        assertEquals(verde.getVida(),100,0.001);
    }
    
    @Test 
    public void elfoVerdeNasceComVivo(){
        Elfo verde = new ElfoVerde("Legolas");
        assertEquals(verde.getStatus(),Status.VIVO);
    }
}
