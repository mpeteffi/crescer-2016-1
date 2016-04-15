import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class NoturnosPorUltimoTest{
    
    @Test
    public void atacarHordaDeElfosNoturnosUltimo(){
        //criar exercito com 6 elfos
        ExercitoDeElfos e1 = new ExercitoDeElfos();
        Elfo ev1 = new ElfoVerde("ev1");
        Elfo ev2 = new ElfoVerde("ev2");
        Elfo en1 = new ElfoNoturno("en1");
        Elfo en2 = new ElfoNoturno("en2");
        e1.alistarUmElfo(en1);
        e1.alistarUmElfo(en2);
        e1.alistarUmElfo(ev1);
        e1.alistarUmElfo(ev2);
        //criar horda de dwarves com 2 elfos
        ArrayList<Dwarf> hordaDeAnoes = new ArrayList<>();
        Dwarf a1 = new Dwarf("a1");
        Dwarf a2 = new Dwarf("a2");
        hordaDeAnoes.add(a1);
        hordaDeAnoes.add(a2);
        //atacar usando arteDaGuerra
        EstrategiaDeAtaque estrategia = new NoturnosPorUltimo(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        //comparar ordem de ataque com o esperado
        assertTrue(ordemAtaque.get(0)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(1)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(2)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(3)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(4)instanceof ElfoNoturno);
        assertTrue(ordemAtaque.get(5)instanceof ElfoNoturno);
        assertTrue(ordemAtaque.get(6)instanceof ElfoNoturno);
        assertTrue(ordemAtaque.get(7)instanceof ElfoNoturno);
    }
       
    @Test
    public void atacarHordaDeElfosNoturnosUltimoAddAleatorio(){
        //criar exercito com 6 elfos
        ExercitoDeElfos e1 = new ExercitoDeElfos();
        Elfo ev1 = new ElfoVerde("ev1");
        Elfo ev2 = new ElfoVerde("ev2");
        Elfo ev3 = new ElfoVerde("ev3");
        Elfo en1 = new ElfoNoturno("en1");
        Elfo en2 = new ElfoNoturno("en2");
        Elfo en3 = new ElfoNoturno("en3");
        e1.alistarUmElfo(en1);
        e1.alistarUmElfo(en2);
        e1.alistarUmElfo(ev1);
        e1.alistarUmElfo(ev2);
        e1.alistarUmElfo(en3);
        e1.alistarUmElfo(ev3);
        //criar horda de dwarves com 2 elfos
        ArrayList<Dwarf> hordaDeAnoes = new ArrayList<>();
        Dwarf a1 = new Dwarf("a1");
        Dwarf a2 = new Dwarf("a2");
        hordaDeAnoes.add(a1);
        hordaDeAnoes.add(a2);
        //atacar usando arteDaGuerra
        EstrategiaDeAtaque estrategia = new NoturnosPorUltimo(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        //comparar ordem de ataque com o esperado
        assertTrue(ordemAtaque.get(0)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(1)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(2)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(3)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(4)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(5)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(6)instanceof ElfoNoturno);
        assertTrue(ordemAtaque.get(7)instanceof ElfoNoturno);
        assertTrue(ordemAtaque.get(8)instanceof ElfoNoturno);
        assertTrue(ordemAtaque.get(9)instanceof ElfoNoturno);
        assertTrue(ordemAtaque.get(10)instanceof ElfoNoturno);
        assertTrue(ordemAtaque.get(11)instanceof ElfoNoturno);
    }
}
