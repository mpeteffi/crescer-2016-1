

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class AtaqueIntercaladoTest
{
    @Test
    public void atacarHordaAtaqueIintercaladoTodosVivos(){
        //criar exercito com 3 ElfosVerdes e 3 ElfosNoturnos
        ExercitoDeElfos e1 = criarExercitoDeElfos(3, 3);
        
        //criar horda de dwarves com 2 anoes
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(2);
        
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
        assertTrue(ordemAtaque.get(6)instanceof ElfoVerde && 
            ordemAtaque.get(8)instanceof ElfoNoturno || 
            ordemAtaque.get(6)instanceof ElfoNoturno &&
            ordemAtaque.get(8)instanceof ElfoVerde);

    }
    
    public ExercitoDeElfos criarExercitoDeElfos(int verdes, int noturnos){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        for(int i=1;i<=verdes;i++){
            exercito.alistarUmElfo(new ElfoVerde("ElfoVerde" + i));
        }
        for(int i=1;i<=noturnos;i++){
            exercito.alistarUmElfo(new ElfoNoturno("ElfoNoturno" + i));
        }
    
        return exercito;
    }
    
    public ArrayList<Dwarf> criarHordaDwarves(int anoes){
        ArrayList<Dwarf> horda = new ArrayList<>();
        
        for(int i=1;i<=anoes;i++){
            horda.add(new Dwarf("Anao" + i));
        }
    
        return horda;
    }
}
