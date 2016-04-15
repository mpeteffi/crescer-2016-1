
import java.util.*;
public class NoturnosPorUltimo implements EstrategiaDeAtaque{
    private HashMap<String, Elfo> exercito;
    private ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    
    public NoturnosPorUltimo(HashMap<String, Elfo> exercito1){
        this.exercito=exercito1;
    }
    
    public ArrayList<Elfo> atacarHorda(ArrayList<Dwarf> osAnoes){
        ordemDoAtaque = new ArrayList<>();
        for(String chaveNomeElfo : exercito.keySet()){
            Elfo oElfo=this.exercito.get(chaveNomeElfo);
            if(oElfo.getStatus() == Status.VIVO && oElfo instanceof ElfoVerde){
                for(Dwarf oAnao : osAnoes){
                    oElfo.atirarFlecha(oAnao);
                    ordemDoAtaque.add(oElfo);
                }
            }
        }
        for(String chaveNomeElfo : exercito.keySet()){
            Elfo oElfo=this.exercito.get(chaveNomeElfo);
            if(oElfo.getStatus() == Status.VIVO && oElfo instanceof ElfoNoturno){
                for(Dwarf oAnao : osAnoes){
                    oElfo.atirarFlecha(oAnao);
                    ordemDoAtaque.add(oElfo);
                }
            }
        }
               
        
        return this.ordemDoAtaque;
    }
}
