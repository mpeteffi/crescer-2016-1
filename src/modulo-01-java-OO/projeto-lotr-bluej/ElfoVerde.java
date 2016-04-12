import java.util.ArrayList;

public class ElfoVerde extends Elfo {
    
    public ElfoVerde(String nome){ 
        super(nome);
    }
    
    public ElfoVerde(String nome, int flechas){ 
        super(nome, flechas);
    }
    
    public void atirarFlecha(Dwarf gimli){
            this.flechas--;
            experiencia=experiencia+2;
            gimli.perderVida();
            } 
    
    public void adicionarItem(Item item){
        if (item.getDescricao()=="Espada de aço valiriano" ||
            item.getDescricao()=="Arco e Flecha de Vidro"){
                super.adicionarItem(item);
            }
    }
}

