import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class arteDaGuerraTest{
    
    @Test
    public void atacarHordaDeElfosArteDaGuerra6e2(){
        //criar exercito com 6 elfos
        ExercitoDeElfos e1 = new ExercitoDeElfos();
        Elfo ev1 = new ElfoVerde("ev1");
        Elfo en1 = new ElfoNoturno("en1");
        Elfo en2 = new ElfoNoturno("en2");
        Elfo en3 = new ElfoNoturno("en3");
        e1.alistarUmElfo(ev1);
        e1.alistarUmElfo(en1);
        e1.alistarUmElfo(en2);
        e1.alistarUmElfo(en3);
        //criar horda de dwarves com 2 elfos
        ArrayList<Dwarf> hordaDeAnoes = new ArrayList<>();
        Dwarf a1 = new Dwarf("a1");
        Dwarf a2 = new Dwarf("a2");
        hordaDeAnoes.add(a1);
        hordaDeAnoes.add(a2);
        //atacar usando arteDaGuerra
        EstrategiaDeAtaque estrategia = new ArteDaGuerra(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        //comparar ordem de ataque com o esperado
        assertTrue(ordemAtaque.contains(ev1));
        int cont=0;
        if(ordemAtaque.contains(en1)){cont++;};
        if(ordemAtaque.contains(en2)){cont++;};
        if(ordemAtaque.contains(en3)){cont++;};
        assertEquals(cont,1);
        assertTrue(ordemAtaque.size()==4);
    }
       
}
