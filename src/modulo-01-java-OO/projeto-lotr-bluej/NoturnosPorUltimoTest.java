import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class NoturnosPorUltimoTest{
    
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
