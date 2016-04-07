import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    
    @Test
    public void testeAtribuirNomeEFlechas(){
        Elfo legolas = new Elfo("Legolas",30);
        assertEquals("Legolas",legolas.getNome());
        assertEquals(30,legolas.getFlechas());
    }
    
    @Test
    public void testeAtribuirNomeVazioE120Flechas(){
        Elfo legolas = new Elfo("",120);
        assertEquals("",legolas.getNome());
        assertEquals(120,legolas.getFlechas());
    }
    
    @Test
    public void testeAtribuirNomeVazio120FlechasEAtira(){
        Elfo legolas = new Elfo("",120);
        Dwarf d1 = new Dwarf("gimli");
        legolas.atirarFlecha(d1);
        assertEquals("",legolas.getNome());
        assertEquals(119,legolas.getFlechas());
        assertEquals(1,legolas.getExperiencia());
    }
    
    @Test
    public void testeAtribuirNome(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals("Legolas",legolas.getNome());
    }
    
    @Test
    public void testeAtribuirFlechas(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals(42,legolas.getFlechas());
    }
    
    @Test
    public void testePerderFlechas(){
        Elfo legolas = new Elfo("Legolas");
        Dwarf gimli = new Dwarf("gimli");
        legolas.atirarFlecha(gimli);
        assertEquals(41,legolas.getFlechas());
    }
    
    @Test
    public void testeGanharExperiencia(){
        Elfo legolas = new Elfo("Legolas");
        Dwarf gimli = new Dwarf("gimli");
        legolas.atirarFlecha(gimli);
        assertEquals(1,legolas.getExperiencia());
    }
    
    @Test
    public void testeTirarVidaDwarf(){
        Elfo legolas = new Elfo("Legolas");
        Dwarf gimli = new Dwarf("gimli");
        legolas.atirarFlecha(gimli);
        assertEquals(100,gimli.getVida());
    }
    
    @Test
    public void testeCriacaoToString(){
        Elfo legolas = new Elfo("Legolas");
        String esperado = "Legolas possui 42 flechas e 0 níveis de experiência.";
        assertEquals(esperado,legolas.toString());
    }
}
