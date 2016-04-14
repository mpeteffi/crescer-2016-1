import java.util.*;

public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    public HashMap<Status, ArrayList<Elfo>> elfosDivididos = new HashMap<>();
    
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
    
    public boolean procurarElfoAgrupado(Status status, Elfo elfo){
        return this.elfosDivididos.get(status).contains(elfo);
    }
    
    public void agruparPorStatus(){
        for (String chaveNomeElfo : exercito.keySet()){
            Elfo oElfo = exercito.get(chaveNomeElfo);
            Status statusDoElfo = oElfo.getStatus();
            
            if (this.elfosDivididos.get(statusDoElfo) == null) { 
                this.elfosDivididos.put(statusDoElfo, new ArrayList<Elfo>());
                this.elfosDivididos.get(statusDoElfo).add(oElfo);
            } else {
                this.elfosDivididos.get(statusDoElfo).add(oElfo); 
            }
        }
    }
}

