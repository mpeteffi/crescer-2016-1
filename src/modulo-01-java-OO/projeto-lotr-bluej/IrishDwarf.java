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
                int quantidade = this.bolsa.getLista().get(i).getQuantidade();
                int soma = 0;
                soma=(quantidade*(quantidade+1))/2;
                quantidade += soma*1000;
                this.bolsa.getLista().get(i).setQuantidade(quantidade);
            }
        }
    }
    
}

