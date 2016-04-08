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
        assertEquals(i1,d1.getInventario().getItem().get(0));
    }
    
    @Test
    public void testeDwarfPerdeItem(){
        Dwarf d1 = new Dwarf("João");
        Item i1 = new Item(1,"Martelo");
        d1.adicionarItem(i1);
        assertEquals(i1,d1.getInventario().getItem().get(0));
        d1.perderItem(i1);
        assertEquals(0,d1.getInventario().getItem().size());
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
    
    @Test
    public void testeDwarfNumeroSorte101(){
        Dwarf d1 = new Dwarf("João");
        assertTrue(d1.getNumeroSorte()==101.0);
    }
    
    @Test
    public void testeDwarfNumeroSorteBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2016);
        Dwarf d1 = new Dwarf("João",data);
        d1.perderVida();
        d1.perderVida();
        assertTrue(d1.getNumeroSorte()==-3333.0);
    }
    
    @Test
    public void testeDwarfNumeroSorteNaoBissextoJoao(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2015);
        Dwarf d1 = new Dwarf("João",data);
        assertTrue(d1.getNumeroSorte()!=33.0);
    }
    
    @Test
    public void testeDwarfNumeroSorteNaoBissextoSeixas(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2015);
        Dwarf d1 = new Dwarf("Seixas",data);
        assertTrue(d1.getNumeroSorte()==33.0);
    }
    
    @Test
    public void testeDwarfNumeroSorteNaoBissextoMeireles(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2015);
        Dwarf d1 = new Dwarf("Meireles",data);
        assertTrue(d1.getNumeroSorte()==33.0);
    }
    
    @Test
    public void testeDwarfSorteNaoPerdeVidaNaoGanhaExp(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2015);
        Dwarf d1 = new Dwarf("Seixas",data);
        //Sorte entre 0 e 100
        d1.perderVida();
        assertEquals(110,d1.getVida());
        assertEquals(0,d1.getExperiencia());
    }
    
    @Test
    public void testeDwarfSortePerdeVidaNaoGanhaExp(){
        Dwarf d1 = new Dwarf("João");
        //Sorte maior que 100
        d1.perderVida();
        assertEquals(100,d1.getVida());
        assertEquals(0,d1.getExperiencia());
    }
    
    @Test
    public void testeDwarfSorteNaoPerdeVidaGanha2Exp(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2016);
        Dwarf d1 = new Dwarf("João",data);
        d1.perderVida();
        d1.perderVida();
        //Sorte menor que 0
        d1.perderVida();
        assertEquals(90,d1.getVida());
        assertEquals(2,d1.getExperiencia());
    }
      
}
