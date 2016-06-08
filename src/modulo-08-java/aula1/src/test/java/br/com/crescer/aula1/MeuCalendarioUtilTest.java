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
        Date data = new GregorianCalendar(2016, 4, 8).getTime();
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "Já se passaram 0 Anos 1 meses e 0 dias.";
        String result = instance.tempoDecorrido(data);
        assertEquals(expResult, result);
    }
    
}
