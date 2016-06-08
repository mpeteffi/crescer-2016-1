package br.com.crescer.aula1;
import java.util.GregorianCalendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Murillo
 */
public class MeuCalendarioUtilTest {
    
    public MeuCalendarioUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void diaDaSemanaTerça() {
        Date data = new GregorianCalendar(2016, 05, 07).getTime(); //07/06/2016
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "Terça-feira";
        String result = instance.diaDaSemana(data);
        assertEquals(expResult, result);
    }
    
    @Test
    public void diaDaSemanaSegunda() {
        Date data = new GregorianCalendar(2016, 05, 06).getTime(); //07/06/2016
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "Segunda-feira";
        String result = instance.diaDaSemana(data);
        assertEquals(expResult, result);
    }
    
    @Test
    public void tempoDecorrido() {
        //DateTime data = new DateTime();
        //MeuCalendarioUtil instance = new MeuCalendarioUtil();
        //String expResult = "aaa";
        //String result = instance.tempoDecorrido(data);
        //assertEquals(new Date(), data.getDay());
    }
    
}
