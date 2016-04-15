
import java.util.*;
public class AtaqueIntercalado implements EstrategiaDeAtaque{
    private HashMap<String, Elfo> exercito;
    private ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    private ArrayList<Elfo> intercalados = new ArrayList<>();
    private int elfosQueAtacam=0;
    
    public AtaqueIntercalado(HashMap<String, Elfo> exercito1){
        this.exercito=exercito1;
    }
    
    public ArrayList<Elfo> atacarHorda(ArrayList<Dwarf> osAnoes){
        this.ordemDoAtaque = new ArrayList<>();
        //atacando para caso 50-50%
        if(verificar5050()){
            this.intercalados = intercalarElfos();
            //percorrer intercalados e atira
            for(int i=0;i<intercalados.size();i++){
                Elfo oElfo = this.intercalados.get(i);
                //percorrer Anoes
                for(Dwarf oAnao : osAnoes){
                    oElfo.atirarFlecha(oAnao);
                    ordemDoAtaque.add(oElfo);
                }
            }
        }
        
        return this.ordemDoAtaque;
    }
    
    public ArrayList<Elfo> intercalarElfos(){
        intercalados = new ArrayList<>();
        int cont=0;
        
        while(cont<elfosQueAtacam) {
            for(String chaveNomeElfo : exercito.keySet()){
                Elfo oElfo=this.exercito.get(chaveNomeElfo);
                if(cont==0 && oElfo.getStatus()==Status.VIVO){
                    this.intercalados.add(oElfo);
                    cont++;
                } else {        
                   
                if(this.intercalados.get(cont-1) instanceof ElfoVerde && 
                        oElfo instanceof ElfoNoturno && 
                        oElfo.getStatus()==Status.VIVO || 
                        this.intercalados.get(cont-1) instanceof ElfoNoturno &&
                        oElfo instanceof ElfoVerde && 
                        oElfo.getStatus()==Status.VIVO){
                            this.intercalados.add(oElfo);
                            cont++;
                    }
                }
            }
        }   
            
        return intercalados;
    }
    
    public boolean verificar5050(){
        int nVerde=0, nNoturno=0;
        elfosQueAtacam=0;
        boolean meioAMeio = false;
        //verificando se o exercito tem 50% verde e 50% noturno dos vivos
        for(String chaveNomeElfo : this.exercito.keySet()){
            Elfo oElfo=this.exercito.get(chaveNomeElfo);
            if(oElfo instanceof ElfoVerde && oElfo.getStatus()==Status.VIVO){
                nVerde++;
            }
            if(oElfo instanceof ElfoNoturno && oElfo.getStatus()==Status.VIVO){
                nNoturno++;
            }
        }
        elfosQueAtacam=nVerde+nNoturno;
        return meioAMeio = nVerde==nNoturno;
    }
}
