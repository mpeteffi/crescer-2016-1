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
        assertFalse(data.ehBissexto());
    }
    
    @Test
    public void teste2016EhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
        assertTrue(data.ehBissexto());
    }

    @Test
    public void teste2017NaoEhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,2017);
        assertFalse(data.ehBissexto());
    }

    @Test
    public void teste4000EhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,4000);
        assertTrue(data.ehBissexto());
    }
    
    @Test
    public void teste3500NaoEhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,3500);
        assertFalse(data.ehBissexto());
    }
}
