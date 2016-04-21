import java.util.*;
public class AtaqueIntercalado implements EstrategiaDeAtaque{
    private HashMap<String, Elfo> exercito;
    private ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    private ArrayList<Elfo> intercalados = new ArrayList<>();
    private int elfosQueAtacam;
    
    public AtaqueIntercalado(HashMap<String, Elfo> exercito1){
        this.exercito=exercito1;
    }
    
    public ArrayList<Elfo> atacarHorda(ArrayList<Dwarf> osAnoes){
        this.ordemDoAtaque = new ArrayList<>();
        
        //verifica se são 50% de cada tipo de elfo para poder atacar
        if(verificar5050()){
            
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
    
    public ArrayList<Elfo> intercalarElfos(){
        intercalados = new ArrayList<>();
        int cont=0;
        
        //while para garantir o numero de elfos que atacam
        while(cont<elfosQueAtacam) {
            
            //percorrer elfos para atacar
            for(String chaveNomeElfo : exercito.keySet()){
                Elfo oElfo=this.exercito.get(chaveNomeElfo);
                boolean elfoVivo = oElfo.getStatus()==Status.VIVO;
                
                /*boolean naoEstaNaLista verifica se o Elfo atual ainda não está 
                na lista dos intercalados para atacar*/
                boolean naoEstaNaLista = !(this.intercalados.contains(oElfo));
                
                //verificar se é o primeiro a atacar
                if(cont==0 && elfoVivo && naoEstaNaLista){
                    this.intercalados.add(oElfo);
                    cont++;
                } else {  //para o segundo em diante      
                    
                    /*boolean intercalados para verificar se atual elfo tem
                    instancia diferente do que atacou anteriormente.*/
                    boolean intercalados = oElfo instanceof ElfoNoturno &&
                        this.intercalados.get(cont-1) instanceof ElfoVerde ||
                        this.intercalados.get(cont-1) instanceof ElfoNoturno &&
                        oElfo instanceof ElfoVerde;
                        
                    if(intercalados && elfoVivo && naoEstaNaLista){
                            this.intercalados.add(oElfo);
                            cont++;
                    }
                }
            }
        }   
            
        return intercalados;
    }
    
    public boolean verificar5050(){
        int numVerdes=0, numNoturnos=0;
        this.elfosQueAtacam=0;
        boolean meioAMeio = false;
        
        //verificando se o exercito tem 50% verde e 50% noturno dos vivos
        for(String chaveNomeElfo : this.exercito.keySet()){
            Elfo oElfo=this.exercito.get(chaveNomeElfo);
            boolean elfoVivo = oElfo.getStatus()==Status.VIVO;
            
            if(oElfo instanceof ElfoVerde && elfoVivo){
                numVerdes++;
            }
            if(oElfo instanceof ElfoNoturno && elfoVivo){
                numNoturnos++;
            }
        }
        
        this.elfosQueAtacam = numVerdes + numNoturnos;
        return meioAMeio = numVerdes==numNoturnos;
    }
}
