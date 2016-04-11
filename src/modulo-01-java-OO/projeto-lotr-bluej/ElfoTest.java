import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void atribuirApenasNome(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals("Legolas",legolas.getNome());
    }
    
    @Test
    public void atribuirNomeEFlechasCorretamente(){
        Elfo legolas = new Elfo("Legolas",30);
        assertEquals("Legolas",legolas.getNome());
        assertEquals(30,legolas.getFlechas());
    }
    
    @Test
    public void atribuirNomeVazioE120Flechas(){
        Elfo legolas = new Elfo("",120);
        assertEquals("",legolas.getNome());
        assertEquals(120,legolas.getFlechas());
    }
    
    @Test
    public void atribuirNomeVazio120FlechasEAtirar(){
        Elfo legolas = new Elfo("",120);
        Dwarf d1 = new Dwarf("gimli");
        legolas.atirarFlecha(d1);
        assertEquals("",legolas.getNome());
        assertEquals(119,legolas.getFlechas());
        assertEquals(1,legolas.getExperiencia());
    }
    
    @Test
    public void atribuir42FlechasPorPadrao(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals(42,legolas.getFlechas());
    }
    
    @Test
    public void perderFlechasAoAtirar(){
        Elfo legolas = new Elfo("Legolas");
        Dwarf gimli = new Dwarf("gimli");
        legolas.atirarFlecha(gimli);
        assertEquals(41,legolas.getFlechas());
    }
    
    @Test
    public void ganharExperienciaAoAtirar(){
        Elfo legolas = new Elfo("Legolas");
        Dwarf gimli = new Dwarf("gimli");
        legolas.atirarFlecha(gimli);
        assertEquals(1,legolas.getExperiencia());
        legolas.atirarFlecha(gimli);
        assertEquals(2,legolas.getExperiencia());
    }
    
    @Test
    public void tirarVidaDwarfAoAtirar(){
        Elfo legolas = new Elfo("Legolas");
        Dwarf gimli = new Dwarf("gimli");
        legolas.atirarFlecha(gimli);
        assertEquals(100,gimli.getVida());
        legolas.atirarFlecha(gimli);
        assertEquals(90,gimli.getVida());
    }
    
    @Test
    public void criacaoToStringConformeDados(){
        Elfo legolas = new Elfo("Legolas");
        String esperado = "Legolas possui 42 flechas e 0 níveis de experiência.";
        assertEquals(esperado,legolas.toString());
    }
    
    @Test
    public void toStringParaElfoLegolasCom1Flecha(){
        Elfo legolas = new Elfo("Legolas",1);
        String esperado = "Legolas possui 1 flecha e 0 níveis de experiência.";
        assertEquals(esperado,legolas.toString());
    }
    
    @Test
    public void toStringElfoLegolasCom10FlechasEAtiraUma(){
        Elfo legolas = new Elfo("Legolas",10);
        legolas.atirarFlecha(new Dwarf("gimli"));
        String esperado = "Legolas possui 9 flechas e 1 nível de experiência.";
        assertEquals(esperado,legolas.toString());
    }
    
    @Test
    public void elfoGanhaItem(){
        Elfo d1 = new Elfo("João");
        Item i1 = new Item(1,"Martelo");
        d1.adicionarItem(i1);
        assertEquals(i1,d1.getInventario().getLista().get(0));
    }
    
    @Test
    public void elfoPerdeItem(){
        Elfo d1 = new Elfo("João");
        Item i1 = new Item(1,"Martelo");
        d1.adicionarItem(i1);
        assertEquals(i1,d1.getInventario().getLista().get(0));
        d1.perderItem(i1);
        assertEquals(0,d1.getInventario().getLista().size());
    }
}
