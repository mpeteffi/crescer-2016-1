import java.util.ArrayList;

public class ElfoVerde extends Elfo {
    
    public ElfoVerde(String nome){ 
        super(nome);
    }
    
    public ElfoVerde(String nome, int flechas){ 
        super(nome, flechas);
    }
    
    public void atirarFlecha(Dwarf gimli){
            super.atirarFlecha(gimli);
            this.experiencia++;
    } 
    
    public void adicionarItem(Item item){
        boolean podeAdicionar = item!= null && 
                item.getDescricao()=="Espada de aço valiriano" ||
                item!= null && 
                item.getDescricao()=="Arco e Flecha de Vidro";
            
        if (podeAdicionar){
                super.adicionarItem(item);
        }
    }
}

