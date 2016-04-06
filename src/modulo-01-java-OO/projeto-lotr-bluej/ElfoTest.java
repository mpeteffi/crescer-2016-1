import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void criarTesteNome(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals("Legolas",legolas.getNome());
    }
    
    @Test
    public void criarTesteAtribuicaoFlechas(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals(42,legolas.getFlechas());
    }
    
    @Test
    public void criarTestePerdeFlechas(){
        Elfo legolas = new Elfo("Legolas");
        Dwarf gimli = new Dwarf("gimli");
        legolas.atirarFlecha(gimli);
        assertEquals(41,legolas.getFlechas());
    }
    
    @Test
    public void criarTesteGanhaExperiencia(){
        Elfo legolas = new Elfo("Legolas");
        Dwarf gimli = new Dwarf("gimli");
        legolas.atirarFlecha(gimli);
        assertEquals(1,legolas.getExperiencia());
    }
    
    @Test
    public void criarTesteTirarVidaDwarf(){
        Elfo legolas = new Elfo("Legolas");
        Dwarf gimli = new Dwarf("gimli");
        legolas.atirarFlecha(gimli);
        assertEquals(100,gimli.getVida());
    }
}
