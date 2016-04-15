

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class AtaqueIntercaladoTest
{
    @Test
    public void atacarHordaAtaqueIintercaladoTodosVivos(){
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
        EstrategiaDeAtaque estrategia = new AtaqueIntercalado(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        //comparar ordem de ataque com o esperado
        assertTrue(ordemAtaque.get(0)instanceof ElfoVerde && 
            ordemAtaque.get(2)instanceof ElfoNoturno || 
            ordemAtaque.get(0)instanceof ElfoNoturno &&
            ordemAtaque.get(2)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(4)instanceof ElfoVerde && 
            ordemAtaque.get(6)instanceof ElfoNoturno || 
            ordemAtaque.get(4)instanceof ElfoNoturno &&
            ordemAtaque.get(6)instanceof ElfoVerde);

    }
}
