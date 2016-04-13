import java.util.*;

public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    
    public ExercitoDeElfos(){        
     
    }
    
    public void alistarUmElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercito.put(elfo.getNome(),elfo);
        }
    }
    
    public Elfo buscarUmElfo(String string){
        return exercito.get(string);    
    }
    
    public HashMap getExercito(){
        return this.exercito;
    } 
    //exercito.put();
        
        // boolean ehElfoValido = instanceof
}
