import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class NoturnosPorUltimoTest{
    @Test
    public void atacarHordaIntercaladoSoComVerdes(){
        //criar exercito com 3 verdes e 0 noturnos
        ExercitoDeElfos e1 = criarExercitoDeElfos(3,0);
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(6);
        EstrategiaDeAtaque estrategia = new NoturnosPorUltimo(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        for(int i=0;i<18;i++){
            assertTrue(ordemAtaque.get(i)instanceof ElfoVerde);
        }
    }
    
    @Test
    public void atacarHordaIntercaladoSoComNoturnos(){
        //criar exercito com 0 verdes e 6 noturnos
        ExercitoDeElfos e1 = criarExercitoDeElfos(0,6);
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(6);
        EstrategiaDeAtaque estrategia = new NoturnosPorUltimo(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        for(int i=0;i<36;i++){
            assertTrue(ordemAtaque.get(i)instanceof ElfoNoturno);
        }
    }
    
    @Test
    public void atacarComExercitoVazio(){
        ExercitoDeElfos e1 = new ExercitoDeElfos();
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(6);
        EstrategiaDeAtaque estrategia = new NoturnosPorUltimo(e1.getExercito());
        List<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        assertTrue(ordemAtaque.isEmpty());
    }
    
    @Test
    public void atacarHordaDeElfosNoturnosUltimo2e2(){
        //criar exercito com 2 verdes e 2 noturnos
        ExercitoDeElfos e1 = criarExercitoDeElfos(2, 2);
        
        //criar horda de dwarves com 2 elfos
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(2);
        
        //atacar usando arteDaGuerra
        EstrategiaDeAtaque estrategia = new NoturnosPorUltimo(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        
        //comparar ordem de ataque com o esperado
        for(int i=0;i<4;i++){
            assertTrue(ordemAtaque.get(i)instanceof ElfoVerde);
        }
        for(int i=4;i<8;i++){
            assertTrue(ordemAtaque.get(i)instanceof ElfoNoturno);
        }
    }
    
    @Test
    public void atacarHordaDeElfosNoturnosUltimo4e1(){
        ExercitoDeElfos e1 = criarExercitoDeElfos(4, 1);
        
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(2);
        
        EstrategiaDeAtaque estrategia = new NoturnosPorUltimo(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        
        for(int i=0;i<8;i++){
            assertTrue(ordemAtaque.get(i)instanceof ElfoVerde);
        }
        for(int i=8;i<10;i++){
            assertTrue(ordemAtaque.get(i)instanceof ElfoNoturno);
        }
    }
    
    @Test
    public void atacarHordaDeElfosNoturnosUltimo5e3(){
        ExercitoDeElfos e1 = criarExercitoDeElfos(5, 3);
        
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(1);
        
        EstrategiaDeAtaque estrategia = new NoturnosPorUltimo(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        
        for(int i=0;i<5;i++){
            assertTrue(ordemAtaque.get(i)instanceof ElfoVerde);
        }
        for(int i=5;i<8;i++){
            assertTrue(ordemAtaque.get(i)instanceof ElfoNoturno);
        }
    }
    
    private ExercitoDeElfos criarExercitoDeElfos(int verdes, int noturnos){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        
        for(int i=1;i<=noturnos;i++){
            exercito.alistarUmElfo(new ElfoNoturno("ElfoNoturno" + i));
        }
        for(int i=1;i<=verdes;i++){
            exercito.alistarUmElfo(new ElfoVerde("ElfoVerde" + i));
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
