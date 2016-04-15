
import java.util.*;
public class ArteDaGuerra implements EstrategiaDeAtaque{
    private HashMap<String, Elfo> exercito;
    private ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    
    
    public ArteDaGuerra(HashMap<String, Elfo> exercito1){
        this.exercito=exercito1;
    }
    
    public ArrayList<Elfo> atacarHorda(ArrayList<Dwarf> osAnoes){
        int maxAtaqueNoturno = (int)(exercito.size()*osAnoes.size()*(0.3)),
        qtdNoturno=0;
        ordemDoAtaque = new ArrayList<>();
        
        for(String chaveNomeElfo : exercito.keySet()){
            if(qtdNoturno <= maxAtaqueNoturno){
                Elfo oElfo=this.exercito.get(chaveNomeElfo);
                if(oElfo.getStatus() == Status.VIVO){
                    for(Dwarf oAnao : osAnoes){
                        oElfo.atirarFlecha(oAnao);
                        ordemDoAtaque.add(oElfo);
                        if(oElfo instanceof ElfoNoturno){
                            qtdNoturno++;
                        } 
                    }
                }
            }
        }
        
        return this.ordemDoAtaque;
    }
}
