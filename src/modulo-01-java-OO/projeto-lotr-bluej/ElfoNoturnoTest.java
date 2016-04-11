import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void ElfoNoturnoGanha3ExpPorFlechada(){
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
    public void ElfoNoturnoPerde5PorCentoDeVidaPorFlechada(){
        Elfo legolas = new ElfoNoturno("Legolas",50);
        assertEquals(legolas.getVida(),100);
        legolas.atirarFlecha(new Dwarf("gimli"));
        assertEquals(legolas.getVida(),95);
    }
}
