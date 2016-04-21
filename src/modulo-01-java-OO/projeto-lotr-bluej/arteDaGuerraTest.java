import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ArteDaGuerraTest{
    
    @Test
    public void atacarHorda1Verde3NoturnoE2Dwarves(){
        //criar exercito com 1 verde e 3 noturnos
        ExercitoDeElfos e1 = criarExercitoDeElfos(1, 3);
        //criar horda de dwarves com 2 elfos
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(2);
        //atacar usando arteDaGuerra
        EstrategiaDeAtaque estrategia = new ArteDaGuerra(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        
        //contarNoturnosEVerdes
        int verdes=0, noturnos=0;
        for(int i=0; i<ordemAtaque.size();i++){
            if(ordemAtaque.get(i) instanceof ElfoVerde){
                verdes++;
            } else {
                noturnos++;
            }
        }
        
        //só podem haver no maximo 2 ataques de noturnos
        assertTrue(noturnos<=2);
        
        //esperado
        assertEquals(2,verdes);
        assertEquals(2,noturnos);
    }
    
    @Test
    public void atacarHorda5Verde7NoturnoE3Dwarves(){
        //criar exercito com 5 verdes e 7 noturnos
        ExercitoDeElfos e1 = criarExercitoDeElfos(5, 7);
        //criar horda de dwarves com 3 elfos
        ArrayList<Dwarf> hordaDeAnoes = criarHordaDwarves(3);
        //atacar usando arteDaGuerra
        EstrategiaDeAtaque estrategia = new ArteDaGuerra(e1.getExercito());
        ArrayList<Elfo> ordemAtaque = estrategia.atacarHorda(hordaDeAnoes);
        
        //contarNoturnosEVerdes
        int verdes=0, noturnos=0;
        for(int i=0; i<ordemAtaque.size();i++){
            if(ordemAtaque.get(i) instanceof ElfoVerde){
                verdes++;
            } else {
                noturnos++;
            }
        }
        
        //só podem haver no maximo 2 ataques de noturnos
        assertTrue(noturnos<=10);
        
        //esperado
        assertEquals(15,verdes);
        assertEquals(10,noturnos);
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
