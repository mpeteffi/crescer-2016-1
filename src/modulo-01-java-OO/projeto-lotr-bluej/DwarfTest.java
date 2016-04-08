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
    
    @Test
    public void testeDwarfGanhaItem(){
        Dwarf d1 = new Dwarf("João");
        Item i1 = new Item(1,"Martelo");
        d1.adicionarItem(i1);
        assertEquals(0,d1.bolsa.procurarItemNaLista(i1));
    }
    
    @Test
    public void testeDwarfPerdeItem(){
        Dwarf d1 = new Dwarf("João");
        Item i1 = new Item(1,"Martelo");
        d1.adicionarItem(i1);
        assertEquals(0,d1.bolsa.procurarItemNaLista(i1));
        d1.perderItem(i1);
        assertEquals(-1,d1.bolsa.procurarItemNaLista(i1));
    }
    
    @Test
    public void testeDwarfRecebe111NascimentoPadrao(){
        Dwarf d1 = new Dwarf("João");
        assertEquals(1,d1.getNascimento().getDia());
        assertEquals(1,d1.getNascimento().getMes());
        assertEquals(1,d1.getNascimento().getAno());
    }
    
    @Test
    public void testeDwarfRecebe10Abr3200Nascimento(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,3200);
        Dwarf d1 = new Dwarf("João",data);
        assertEquals(10,d1.getNascimento().getDia());
        assertEquals(4,d1.getNascimento().getMes());
        assertEquals(3200,d1.getNascimento().getAno());
    }
}
