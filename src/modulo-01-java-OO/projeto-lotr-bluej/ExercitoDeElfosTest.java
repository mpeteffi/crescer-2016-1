

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


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
    
    @Test
    public void agrupaPorStatusCorretamente(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo ev1 = new ElfoVerde("verde1");
        Elfo ev2 = new ElfoVerde("verde2");
        Elfo ev3 = new ElfoVerde("verde3");
        Elfo en1 = new ElfoNoturno("noturno1");
        Elfo en2 = new ElfoNoturno("noturno2");
        Elfo en3 = new ElfoNoturno("noturno3");
        //matar elfos en1 e en2.
        for (int i=0;i<92;i++){
            ev1.atirarFlecha(new Dwarf("gimli"));
            en1.atirarFlecha(new Dwarf("gimli"));
            en2.atirarFlecha(new Dwarf("gimli"));
        }
        //alistar elfos mortos e vivos no exercito.
        exercito.alistarUmElfo(ev1);
        exercito.alistarUmElfo(ev2);
        exercito.alistarUmElfo(ev3);
        exercito.alistarUmElfo(en1);
        exercito.alistarUmElfo(en2);
        exercito.alistarUmElfo(en3);
        //agrupar por status.
        exercito.agruparPorStatus();
        //testar contains nas chaves VIVO e MORTO.
        assertTrue(exercito.buscarListaAgrupados(Status.VIVO).contains(ev1));
        assertTrue(exercito.buscarListaAgrupados(Status.VIVO).contains(ev2));
        assertTrue(exercito.buscarListaAgrupados(Status.VIVO).contains(ev3));
        assertTrue(exercito.buscarListaAgrupados(Status.VIVO).contains(en3));
        assertTrue(exercito.buscarListaAgrupados(Status.MORTO).contains(en1));
        assertTrue(exercito.buscarListaAgrupados(Status.MORTO).contains(en2));
    }
}
