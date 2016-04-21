import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void irishDwarfSorteGanharQMilVezes(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2016);
        IrishDwarf d1 = new IrishDwarf("João",data);
        d1.perderVida();
        d1.perderVida();
        //Sorte menor que 0
        Item i1 = new Item(3,"Poção");
        d1.adicionarItem(i1);
        assertEquals(3,d1.getInventario().getLista().get(0).getQuantidade());
        d1.tentarSorte();
        assertEquals(6003,d1.getInventario().getLista().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfSorteGanharQMilVezesDeCada(){
        DataTerceiraEra data = new DataTerceiraEra(10,4,2016);
        IrishDwarf d1 = new IrishDwarf("João",data);
        d1.perderVida();
        d1.perderVida();
        //Sorte menor que 0
        Item i1 = new Item(2,"Poção");
        Item i2 = new Item(4,"Cervejas");
        d1.adicionarItem(i1);
        d1.adicionarItem(i2);
        assertEquals(2,d1.getInventario().getLista().get(0).getQuantidade());
        assertEquals(4,d1.getInventario().getLista().get(1).getQuantidade());
        d1.tentarSorte();
        assertEquals(3002,d1.getInventario().getLista().get(0).getQuantidade());
        assertEquals(10004,d1.getInventario().getLista().get(1).getQuantidade());
    }
}