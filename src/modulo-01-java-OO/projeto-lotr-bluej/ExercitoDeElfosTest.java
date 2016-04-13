

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ExercitoDeElfosTest
{
    @After
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void alistarUmElfoNoturnoOuVerde(){
        Elfo l1 = new Elfo("Legolas1");
        Elfo l2 = new ElfoNoturno("Legolas2");
        Elfo l3 = new ElfoVerde("Legolas3");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarUmElfo(l1);
        exercito.alistarUmElfo(l2);
        exercito.alistarUmElfo(l3);
        assertFalse(exercito.getExercito().containsKey("Legolas1"));
        assertTrue(exercito.getExercito().containsKey("Legolas2"));
        assertTrue(exercito.getExercito().containsKey("Legolas3"));
    }
    
    @Test
    public void buscarUmElfoNoExercito(){
        Elfo l1 = new Elfo("Legolas1");
        Elfo l2 = new ElfoNoturno("Legolas2");
        Elfo l3 = new ElfoVerde("Legolas3");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarUmElfo(l1);
        exercito.alistarUmElfo(l2);
        exercito.alistarUmElfo(l3);
        assertEquals(l2,exercito.buscarUmElfo("Legolas2"));
        assertEquals(l3,exercito.buscarUmElfo("Legolas3"));
    }
}
