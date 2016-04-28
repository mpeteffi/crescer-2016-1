

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class AtaqueIntercaladoTest
{
    @Test
    public void atacarHordaIntercaladoSoComNoturnos(){
        //criar exercito com 0 verdes e 3 noturnos
        ExercitoDeElfos e1 = criarExercitoDeElfos(0,3);
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(2);
        EstrategiaDeAtaque estrategia = new AtaqueIntercalado(e1.getExercito());
        assertTrue(estrategia.getOrdemUltimoAtaque().equals(new ArrayList<Elfo>()));
    }
    
    @Test
    public void atacarHordaIntercaladoSoComVerdes(){
        //criar exercito com 3 verdes e 0 noturnos
        ExercitoDeElfos e1 = criarExercitoDeElfos(3,0);
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(6);
        EstrategiaDeAtaque estrategia = new AtaqueIntercalado(e1.getExercito());
        assertTrue(estrategia.getOrdemUltimoAtaque().equals(new ArrayList<Elfo>()));
    }
    
    @Test
    public void atacarHordaIntercaladoMaisNoturnos(){
        //criar exercito com 3 verdes e 4 noturnos
        ExercitoDeElfos e1 = criarExercitoDeElfos(3,4);
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(6);
        EstrategiaDeAtaque estrategia = new AtaqueIntercalado(e1.getExercito());
        assertTrue(estrategia.getOrdemUltimoAtaque().equals(new ArrayList<Elfo>()));
    }
    
    @Test
    public void atacarComExercitoVazio(){
        ExercitoDeElfos e1 = new ExercitoDeElfos();
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(6);
        EstrategiaDeAtaque estrategia = new AtaqueIntercalado(e1.getExercito());
        List<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        assertTrue(ordemAtaque.isEmpty());
    }
    
    @Test
    public void atacarHordaIntercaladoMaisVerdes(){
        //criar exercito com 3 verdes e 2 noturnos
        ExercitoDeElfos e1 = criarExercitoDeElfos(3,2);
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(6);
        EstrategiaDeAtaque estrategia = new AtaqueIntercalado(e1.getExercito());
        assertTrue(estrategia.getOrdemUltimoAtaque().equals(new ArrayList<Elfo>()));
    }
    
    @Test
    public void atacarHordaAtaqueIintercalado2anoes3verdes3noturnos(){
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
    
    @Test
    public void atacarHordaAtaqueIintercalado3anoes2verdes2noturnos(){
        ExercitoDeElfos e1 = criarExercitoDeElfos(2, 2);
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(3);
        
        EstrategiaDeAtaque estrategia = new AtaqueIntercalado(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        
        //comparar ordem de ataque com o esperado
        assertTrue(ordemAtaque.get(0)instanceof ElfoVerde && 
            ordemAtaque.get(3)instanceof ElfoNoturno || 
            ordemAtaque.get(0)instanceof ElfoNoturno &&
            ordemAtaque.get(3)instanceof ElfoVerde);
        assertTrue(ordemAtaque.get(3)instanceof ElfoVerde && 
            ordemAtaque.get(6)instanceof ElfoNoturno || 
            ordemAtaque.get(3)instanceof ElfoNoturno &&
            ordemAtaque.get(6)instanceof ElfoVerde);
    }
    
    private ExercitoDeElfos criarExercitoDeElfos(int verdes, int noturnos){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        for(int i=1;i<=verdes;i++){
            exercito.alistarUmElfo(new ElfoVerde("ElfoVerde" + i));
        }
        for(int i=1;i<=noturnos;i++){
            exercito.alistarUmElfo(new ElfoNoturno("ElfoNoturno" + i));
        }
    
        return exercito;
    }
    
    private ArrayList<Dwarf> criarHordaDwarves(int anoes){
        ArrayList<Dwarf> horda = new ArrayList<>();
        
        for(int i=1;i<=anoes;i++){
            horda.add(new Dwarf("Anao" + i));
        }
    
        return horda;
    }
}
