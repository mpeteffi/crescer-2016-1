import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void atribuirNome(){
        Dwarf d1 = new Dwarf("Joao");
        assertEquals("Joao",d1.getNome());
    }
    
    @Test
    public void atribuicaoVida(){
        Dwarf d1 = new Dwarf("Joao");
        assertEquals(110,d1.getVida(),0.001);
    }
    
    @Test
    public void dawrfPerdeVida(){
        Dwarf d1 = new Dwarf("Joao");
        d1.perderVida();
        assertEquals(100,d1.getVida(),0.001);
    }
    
    @Test
    public void dwarfNasceVivo(){
        Dwarf d1 = new Dwarf("Joao");
        assertEquals(Status.VIVO,d1.getStatus());
    }
    
    @Test
    public void dwarfComVida0Morre(){
        Dwarf d1 = new Dwarf("Joao");
        for(int i=1;i<=11;i++){d1.perderVida();}
        assertEquals(Status.MORTO,d1.getStatus());
    }
    
    @Test
    public void dwarfVidaNuncaNegativa(){
        Dwarf d1 = new Dwarf("Joao");
        for(int i=1;i<=15;i++){d1.perderVida();}
        assertEquals(0,d1.getVida(),0.001);
    }
    
    @Test
    public void dwarfMortoSempreComVida0(){
        Dwarf d1 = new Dwarf("Joao");
        for(int i=1;i<=15;i++){d1.perderVida();}
        assertEquals(0,d1.getVida(),0.001);
        assertEquals(Status.MORTO,d1.getStatus());
    }
    
    @Test
    public void dwarfGanhaItem(){
        Dwarf d1 = new Dwarf("João");
        Item i1 = new Item(1,"Martelo");
        d1.adicionarItem(i1);
        assertEquals(i1,d1.getInventario().getLista().get(0));
    }
    
    @Test
    public void dwarfPerdeItem(){
        Dwarf d1 = new Dwarf("João");
        Item i1 = new Item(1,"Martelo");
        d1.adicionarItem(i1);
        assertEquals(i1,d1.getInventario().getLista().get(0));
        d1.perderItem(i1);
        assertEquals(0,d1.getInventario().getLista().size());
    }
    
    @Test
    public void dwarfRecebe111NascimentoPadrao(){
        Dwarf d1 = new Dwarf("João");
        assertEquals(1,d1.getNascimento().getDia());
        assertEquals(1,d1.getNascimento().getMes());
        assertEquals(1,d1.getNascimento().getAno());
    }
    
    @Test
    public void dwarfRecebe10Abr3200Nascimento(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,3200);
        Dwarf d1 = new Dwarf("João",data);
        assertEquals(10,d1.getNascimento().getDia());
        assertEquals(4,d1.getNascimento().getMes());
        assertEquals(3200,d1.getNascimento().getAno());
    }
    
    @Test
    public void dwarfNumeroSorte101(){
        Dwarf d1 = new Dwarf("João");
        assertTrue(d1.getNumeroSorte()==101.0);
    }
    
    @Test
    public void dwarfNumeroSorteBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2016);
        Dwarf d1 = new Dwarf("João",data);
        d1.perderVida();
        d1.perderVida();
        assertTrue(d1.getNumeroSorte()==-3333.0);
    }
    
    @Test
    public void dwarfNumeroSorteNaoBissextoJoao(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2015);
        Dwarf d1 = new Dwarf("João",data);
        assertTrue(d1.getNumeroSorte()!=33.0);
    }
    
    @Test
    public void dwarfNumeroSorteNaoBissextoSeixas(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2015);
        Dwarf d1 = new Dwarf("Seixas",data);
        assertTrue(d1.getNumeroSorte()==33.0);
    }
    
    @Test
    public void dwarfNumeroSorteNaoBissextoMeireles(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2015);
        Dwarf d1 = new Dwarf("Meireles",data);
        assertTrue(d1.getNumeroSorte()==33.0);
    }
    
    @Test
    public void dwarfSorteNaoPerdeVidaNaoGanhaExp(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2015);
        Dwarf d1 = new Dwarf("Seixas",data);
        //Sorte entre 0 e 100
        d1.perderVida();
        assertEquals(110,d1.getVida(),0.001);
        assertEquals(0,d1.getExperiencia());
    }
    
    @Test
    public void dwarfSortePerdeVidaNaoGanhaExp(){
        Dwarf d1 = new Dwarf("João");
        //Sorte maior que 100
        d1.perderVida();
        assertEquals(100,d1.getVida(),0.001);
        assertEquals(0,d1.getExperiencia());
    }
    
    @Test
    public void dwarfSorteNaoPerdeVidaGanha2Exp(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2016);
        Dwarf d1 = new Dwarf("João",data);
        d1.perderVida();
        d1.perderVida();
        //Sorte menor que 0
        d1.perderVida();
        assertEquals(90,d1.getVida(),0.001);
        assertEquals(2,d1.getExperiencia());
    }
    
    @Test
    public void dwarfSorteGanharMilItens(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2016);
        Dwarf d1 = new Dwarf("João",data);
        d1.perderVida();
        d1.perderVida();
        //Sorte menor que 0
        Item i1 = new Item(1,"Poção");
        d1.adicionarItem(i1);
        assertEquals(1,d1.getInventario().getLista().get(0).getQuantidade());
        d1.tentarSorte();
        assertEquals(1001,d1.getInventario().getLista().get(0).getQuantidade());
    }
    
    @Test
    public void dwarfSorteGanharMilItensDeCada(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2016);
        Dwarf d1 = new Dwarf("João",data);
        d1.perderVida();
        d1.perderVida();
        //Sorte menor que 0
        Item i1 = new Item(1,"Poção");
        Item i2 = new Item(3,"Cervejas");
        d1.adicionarItem(i1);
        d1.adicionarItem(i2);
        assertEquals(1,d1.getInventario().getLista().get(0).getQuantidade());
        assertEquals(3,d1.getInventario().getLista().get(1).getQuantidade());
        d1.tentarSorte();
        assertEquals(1001,d1.getInventario().getLista().get(0).getQuantidade());
        assertEquals(1003,d1.getInventario().getLista().get(1).getQuantidade());
    }
    
    @Test
    public void descobrirMenosVidaComIguais(){
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        assertEquals(Dwarf.descobrirMenosVida(d1,d2),d2);
    }
    
    @Test
    public void descobrirMenosVidaPrimeiroMaior(){
        Dwarf d1 = new Dwarf("D1");
        d1.perderVida();
        Dwarf d2 = new Dwarf("D2");
        assertEquals(Dwarf.descobrirMenosVida(d1,d2),d1);
    }
    
    @Test
    public void descobrirMenosVidaSegundoMaior(){
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        d2.perderVida();
        assertEquals(Dwarf.descobrirMenosVida(d1,d2),d2);
    }
}
