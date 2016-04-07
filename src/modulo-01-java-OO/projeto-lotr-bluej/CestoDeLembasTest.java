import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest
{
    @Test
    public void testeCriarCestoCom2Lembas(){
        CestoDeLembas cesto = new CestoDeLembas(2);
        assertEquals(false,cesto.podeDividirEmPares());
    }
    
    @Test
    public void testeCriarCestoCom4Lembas(){
        CestoDeLembas cesto = new CestoDeLembas(4);
        assertEquals(true,cesto.podeDividirEmPares());
    }

    @Test
    public void testeCriarCestoMenos1Lembas(){
        CestoDeLembas cesto = new CestoDeLembas(-1);        
        assertEquals(false,cesto.podeDividirEmPares());
    }
    
    @Test
    public void testeCriarCestoCom101Lembas(){
        CestoDeLembas cesto = new CestoDeLembas(101);
        assertEquals(false,cesto.podeDividirEmPares());
    }
}
