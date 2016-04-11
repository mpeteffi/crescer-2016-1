import java.util.ArrayList;

public class IrishDwarf extends Dwarf {
    
    public IrishDwarf(String nome){ 
        super(nome);
    }
    
    public IrishDwarf(String nome, DataTerceiraEra data){ 
        super(nome, data);
    }
    
    public void tentarSorte(){
        if (getNumeroSorte()==-3333){            
            for(int i=0; i<this.bolsa.getLista().size(); i++){
                int q = this.bolsa.getLista().get(i).getQuantidade();
                int soma = 0;
                soma=(q*(q+1))/2;
                q += soma*1000;
                this.bolsa.getLista().get(i).setQuantidade(q);
            }
        }
    }
    
}

