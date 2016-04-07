import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void criarTesteAtribuicao(){
        DataTerceiraEra data = new DataTerceiraEra(25,02,2011);
        assertEquals(25,data.getDia());
        assertEquals(02,data.getMes());
        assertEquals(2011,data.getAno());
    }
    
    @Test
    public void criarTeste2015Bissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,2015);
        assertEquals(false,data.ehBissexto());
    }
    
    @Test
    public void criarTeste2016Bissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
        assertEquals(true,data.ehBissexto());
    }

    @Test
    public void criarTeste2017Bissexto(){
        DataTerceiraEra data = new DataTerceiraEra(01,01,2017);
        assertEquals(false,data.ehBissexto());
    }
}
