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
    
    public Item itemMaisPopular(){
        int max = 0;
        Item i1 = new Item(0,"Sem Itens");
        
        for(int i=0; i<inventario.size(); i++){
           if (this.inventario.get(i).getQuantidade() > max){
               max = this.inventario.get(i).getQuantidade();
               i1 = this.inventario.get(i);
            }
        }
        
        return i1;
    }
    
    public String getDescricoesItens(){
        String frase = "";
        for(int i=0; i<inventario.size(); i++){
           frase = frase + this.inventario.get(i).getDescricao() + ",";
        }
        
        //for (Item item : this.inventario){
        //  frase += item.getDescricao() + ","; 
        //}
        
        return !this.inventario.isEmpty() ? 
        frase.substring(0, frase.length() - 1) :
        frase;
    }
    
}
