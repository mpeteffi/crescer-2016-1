import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void testeAtribuirNome(){
        Dwarf d1 = new Dwarf("Joao");
        assertEquals("Joao",d1.getNome());
    }
    
    @Test
    public void testeAtribuicaoVida(){
        Dwarf d1 = new Dwarf("Joao");
        assertEquals(110,d1.getVida());
    }
    
    @Test
    public void testeDawrfPerdeVida(){
        Dwarf d1 = new Dwarf("Joao");
        d1.perderVida();
        assertEquals(100,d1.getVida());
    }
    
    @Test
    public void testeDwarfNasceVivo(){
        Dwarf d1 = new Dwarf("Joao");
        assertEquals(Status.VIVO,d1.getStatus());
    }
    
    @Test
    public void testeDwarfComVida0Morre(){
        Dwarf d1 = new Dwarf("Joao");
        for(int i=1;i<=11;i++){d1.perderVida();}
        assertEquals(Status.MORTO,d1.getStatus());
    }
    
    @Test
    public void testeDwarfVidaNuncaNegativa(){
        Dwarf d1 = new Dwarf("Joao");
        for(int i=1;i<=15;i++){d1.perderVida();}
        assertEquals(0,d1.getVida());
    }
    
    @Test
    public void testeDwarfMortoSempreComVida0(){
        Dwarf d1 = new Dwarf("Joao");
        for(int i=1;i<=15;i++){d1.perderVida();}
        assertEquals(0,d1.getVida());
        assertEquals(Status.MORTO,d1.getStatus());
    }
}
