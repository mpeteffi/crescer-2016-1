
import java.util.*;
public class NoturnosPorUltimo implements EstrategiaDeAtaque{
    private HashMap<String, Elfo> exercito;
    private ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    
    public NoturnosPorUltimo(HashMap<String, Elfo> exercito1){
        this.exercito=exercito1;
    }
    
    public ArrayList<Elfo> atacarHorda(ArrayList<Dwarf> osAnoes){
        ordemDoAtaque.clear();
        classeAtacar(ElfoVerde.class, osAnoes);
        classeAtacar(ElfoNoturno.class, osAnoes);
        return this.ordemDoAtaque;
    }

    private void classeAtacar(Class classe, ArrayList<Dwarf> osAnoes) {
        for(String chaveNomeElfo : exercito.keySet()){
            Elfo oElfo=this.exercito.get(chaveNomeElfo);
            boolean elfoVivo = oElfo.getStatus() == Status.VIVO;
            if(elfoVivo && oElfo.getClass() == classe){
                for(Dwarf oAnao : osAnoes){
                    oElfo.atirarFlecha(oAnao);
                    ordemDoAtaque.add(oElfo);
                }
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemUltimoAtaque(){
        return this.ordemDoAtaque;
    }
}
