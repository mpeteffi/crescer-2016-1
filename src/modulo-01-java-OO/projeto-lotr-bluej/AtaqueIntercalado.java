import java.util.*;
public class AtaqueIntercalado implements EstrategiaDeAtaque{
    private HashMap<String, Elfo> exercito;
    private ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    private ArrayList<Elfo> intercalados = new ArrayList<>();
    
    public AtaqueIntercalado(HashMap<String, Elfo> exercito1){
        this.exercito=exercito1;
    }
    
    public ArrayList<Elfo> atacarHorda(ArrayList<Dwarf> osAnoes){
        this.ordemDoAtaque = new ArrayList<>();
        
        //verifica se são 50% de cada tipo de elfo para poder atacar
        if(elfosVivos() && verificar5050()){
            
            //cria um array de elfos verdes e noturnos intercalados
            this.intercalados = intercalarElfos();
            
            //percorrer intercalados para atirar
            for(int i=0;i<intercalados.size();i++){
                Elfo oElfo = this.intercalados.get(i);
                
                //percorrer Anoes para atirar em todos
                for(Dwarf oAnao : osAnoes){
                    oElfo.atirarFlecha(oAnao);
                    ordemDoAtaque.add(oElfo);
                }
            }
        }
        
        return this.ordemDoAtaque;
    }
    
    private ArrayList<Elfo> intercalarElfos(){
        intercalados = new ArrayList<>();
        int cont=0;
        
        //while para garantir o numero de elfos que atacam
        while(cont<exercito.size()) {
            
            //percorrer elfos para atacar
            for(String chaveNomeElfo : exercito.keySet()){
                Elfo oElfo=this.exercito.get(chaveNomeElfo);
                
                /*boolean naoEstaNaLista verifica se o Elfo atual ainda não está 
                na lista dos intercalados para atacar*/
                boolean naoEstaNaLista = !(this.intercalados.contains(oElfo));
                
                if(naoEstaNaLista){
                    
                    //verificar se é o primeiro a atacar
                    if(cont==0){
                        this.intercalados.add(oElfo);
                        cont++;
                    } else {  //para o segundo em diante      
                        Elfo anterior = this.intercalados.get(cont-1);
                    
                        /*boolean intercalados para verificar se atual elfo tem
                         * instancia diferente do que atacou anteriormente.*/
                         boolean intercalados = oElfo instanceof ElfoNoturno &&
                            anterior instanceof ElfoVerde ||
                            anterior instanceof ElfoNoturno &&
                            oElfo instanceof ElfoVerde;
                        
                        if(intercalados){
                            this.intercalados.add(oElfo);
                            cont++;
                        }
                    }
                }   
            }
        }   
            
        return intercalados;
    }
    
    private boolean verificar5050(){
        int numVerdes=0, numNoturnos=0;
        boolean meioAMeio = false;
        
        //verificando se o exercito tem 50% verde e 50% noturno dos vivos
        for(String chaveNomeElfo : this.exercito.keySet()){
            Elfo oElfo=this.exercito.get(chaveNomeElfo);
            
            if(oElfo instanceof ElfoVerde){
                numVerdes++;
            }
            if(oElfo instanceof ElfoNoturno){
                numNoturnos++;
            }
        }
        
        return meioAMeio = numVerdes==numNoturnos;
    }
    
    private boolean elfosVivos(){
        boolean elfosVivos = true;
        
        for(String chaveNomeElfo : this.exercito.keySet()){
            Elfo oElfo=this.exercito.get(chaveNomeElfo);
            
            if(oElfo.getStatus()!=Status.VIVO){
                elfosVivos=false;
                break;
            }
        }
        
        return elfosVivos;
    }
    
    public ArrayList<Elfo> getOrdemUltimoAtaque(){
        return this.ordemDoAtaque;
    }
}
