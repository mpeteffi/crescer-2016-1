package br.com.crescer.aula1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murillo
 */
public class MeuStringUtilTest {
    
    public MeuStringUtilTest() {
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
    public void ehVaziaComStringVazia() {
        String aString = "";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.ehVazia(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void ehVaziaComWhitespace() {
        String aString = "    ";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.ehVazia(aString);
        assertEquals(expResult, result);
    }
    
    @Test (expected = NullPointerException.class)
    public void ehVaziaComNull() {
        String aString = null;
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = false;
        boolean result = instance.ehVazia(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void ehVaziaComTextoValido() {
        String aString = "Texto Válido";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = false;
        boolean result = instance.ehVazia(aString);
        assertEquals(expResult, result);
    }

    @Test
    public void quantidadeVogaisRetornaCerto() {
        String aString = "Quantidade Vogais";
        MeuStringUtil instance = new MeuStringUtil();
        int expResult = 8;
        int result = instance.quantidadeVogais(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void quantidadeVogaisComNenhuma() {
        String aString = "ssddfgtrgh";
        MeuStringUtil instance = new MeuStringUtil();
        int expResult = 0;
        int result = instance.quantidadeVogais(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void quantidadeVogaisComVazio() {
        String aString = "";
        MeuStringUtil instance = new MeuStringUtil();
        int expResult = 0;
        int result = instance.quantidadeVogais(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void quantidadeVogaisComSomenteVogais() {
        String aString = "aaeeiioouu";
        MeuStringUtil instance = new MeuStringUtil();
        int expResult = 10;
        int result = instance.quantidadeVogais(aString);
        assertEquals(expResult, result);
    }
    
    @Test (expected = NullPointerException.class)
    public void quantidadeVogaisComNull() {
        String aString = null;
        MeuStringUtil instance = new MeuStringUtil();
        int expResult = 0;
        int result = instance.quantidadeVogais(aString);
        assertEquals(expResult, result);
    }

    @Test
    public void inverterComSucesso() {
        String aString = "inverter";
        MeuStringUtil instance = new MeuStringUtil();
        String expResult = "retrevni";
        String result = instance.inverter(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void inverterVazio() {
        String aString = "";
        MeuStringUtil instance = new MeuStringUtil();
        String expResult = "";
        String result = instance.inverter(aString);
        assertEquals(expResult, result);
    }
    
    @Test (expected = NullPointerException.class)
    public void inverterNull() {
        String aString = null;
        MeuStringUtil instance = new MeuStringUtil();
        String expResult = "";
        String result = instance.inverter(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void inverterComWhiteSpace() {
        String aString = " ";
        MeuStringUtil instance = new MeuStringUtil();
        String expResult = " ";
        String result = instance.inverter(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void inverterComEspacos() {
        String aString = "a e i o u";
        MeuStringUtil instance = new MeuStringUtil();
        String expResult = "u o i e a";
        String result = instance.inverter(aString);
        assertEquals(expResult, result);
    }

    @Test
    public void palindromoFalso() {
        String aString = "palindromo";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = false;
        boolean result = instance.ehPalindromo(aString);
        assertEquals(expResult, result);
    }
    
    @Test (expected = NullPointerException.class)
    public void palindromoNull() {
        String aString = null;
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = false;
        boolean result = instance.ehPalindromo(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void palindromoVerdadeiroSemEspaco() {
        String aString = "ovo";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.ehPalindromo(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void palindromoVerdadeiroComEspaco() {
        String aString = "ame a ema";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.ehPalindromo(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void palindromoVerdadeiroComEspacoEAcentos() {
        String aString = "A sogra má e amargosa";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.ehPalindromo(aString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void palindromoVerdadeiroComVazio() {
        String aString = "";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.ehPalindromo(aString);
        assertEquals(expResult, result);
    }
}
