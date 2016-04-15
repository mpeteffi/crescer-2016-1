
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
            Elfo oElfo=this.exercito.get(chaveNomeElfo);
            boolean ElfoVivo=oElfo.getStatus() == Status.VIVO;
            
            //verificar instancia do elfo e atacar conforme as regras.
            if(oElfo instanceof ElfoNoturno){
                for(Dwarf oAnao : osAnoes){
                    if(qtdNoturno < maxAtaqueNoturno){
                        oElfo.atirarFlecha(oAnao);
                        ordemDoAtaque.add(oElfo);
                        qtdNoturno++;
                    }
                }
            }
            if(oElfo instanceof ElfoVerde){
                for(Dwarf oAnao : osAnoes){
                    oElfo.atirarFlecha(oAnao);
                    ordemDoAtaque.add(oElfo);
                }
            }
        }
        
        return this.ordemDoAtaque;
    }
}
