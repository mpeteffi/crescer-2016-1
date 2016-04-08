import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> inventario = new ArrayList<>();

    public Inventario(){
        
    }

    public void adicionarItem(Item item){
        this.inventario.add(item);
    }
    
    public void removerItem(Item item){
        this.inventario.remove(item);
    }
    
    public int procurarItemNaLista(Item item){
        int index = inventario.indexOf(item);
        return index;
    }
    
    public ArrayList<Item> getItem(){
        return this.inventario;
    }
    
    public String getDescricoesItens(){
        String frase = "";
        for(int i=0; i<inventario.size(); i++){
           frase = frase + this.inventario.get(i).getDescricao() + ",";
        }
        
        return !this.inventario.isEmpty() ? 
        frase.substring(0, frase.length() - 1) :
        frase;
    }
    
}
