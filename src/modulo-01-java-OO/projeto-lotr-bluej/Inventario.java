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
    
    public ArrayList<Item> getLista(){
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
    
    public void ordenarItens(){
        int quantidadeTemp;
        for(int j=0; j<this.inventario.size(); j++){
            for(int i=0; i<(this.inventario.size()-1); i++){
                if(this.inventario.get(i+1).getQuantidade()<this.inventario.get(i).getQuantidade()){
                    quantidadeTemp = this.inventario.get(i+1).getQuantidade();
                    this.inventario.get(i+1).setQuantidade(this.inventario.get(i).getQuantidade());
                    this.inventario.get(i).setQuantidade(quantidadeTemp);
                }
            }
        }
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
