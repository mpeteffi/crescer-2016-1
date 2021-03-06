import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @After
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void elfoNoturnoGanha3ExpPorFlechada(){
        Elfo legolas = new ElfoNoturno("Legolas",50);
        assertTrue(legolas.getFlechas()==50);
        assertTrue(legolas.getExperiencia()==0);
        legolas.atirarFlecha(new Dwarf("gimli"));
        assertTrue(legolas.getFlechas()==49);
        assertTrue(legolas.getExperiencia()==3);
        legolas.atirarFlecha(new Dwarf("gimli"));
        assertTrue(legolas.getFlechas()==48);
        assertTrue(legolas.getExperiencia()==6);
    }
    
    @Test
    public void elfoNoturnoPerde5PorCentoDeVidaPorFlechada(){
        Elfo legolas = new ElfoNoturno("Legolas",50);
        assertEquals(legolas.getVida(),100,0.001);
        legolas.atirarFlecha(new Dwarf("gimli"));
        assertEquals(legolas.getVida(),95,0.001);
    }
    
    @Test
    public void elfoNoturnoPerde975PorCentoDeVidaPor2Flechada(){
        Elfo legolas = new ElfoNoturno("Legolas",50);
        assertEquals(legolas.getVida(),100,0.001);
        legolas.atirarFlecha(new Dwarf("gimli"));
        legolas.atirarFlecha(new Dwarf("gimli"));
        assertEquals(legolas.getVida(),90.25,0.001);
    }
    
    @Test
    public void elfoNoturnoMorreAoAtirarMuitasFlechas(){
        Elfo legolas = new ElfoNoturno("Legolas",100);
        for(int i=0;i<=90;i++){legolas.atirarFlecha(new Dwarf("gimli"));}
        assertEquals(legolas.getFlechas(),9);
        assertEquals(legolas.getStatus(),Status.MORTO);
    }
}
