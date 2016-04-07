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
}
