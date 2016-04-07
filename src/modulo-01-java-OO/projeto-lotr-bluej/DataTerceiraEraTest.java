import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void testeDataEhCriadaCorretamente(){
        DataTerceiraEra data = new DataTerceiraEra(25,02,2011);
        assertEquals(25,data.getDia());
        assertEquals(02,data.getMes());
        assertEquals(2011,data.getAno());
    }
    
    @Test
    public void teste2015NaoEhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,2015);
        assertEquals(false,data.ehBissexto());
    }
    
    @Test
    public void teste2016EhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
        assertEquals(true,data.ehBissexto());
    }

    @Test
    public void teste2017NaoEhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,2017);
        assertEquals(false,data.ehBissexto());
    }
    
    @Test
    public void teste400EhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,400);
        assertEquals(true,data.ehBissexto());
    }
    
    @Test
    public void teste500NaoEhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,500);
        assertEquals(false,data.ehBissexto());
    }
}
