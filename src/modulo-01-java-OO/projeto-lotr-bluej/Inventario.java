import java.util.ArrayList;

public class Inventario{
    private ArrayList<Item> inventario = new ArrayList<>();

    public Inventario(){}

    public void adicionarItem(Item item){
        this.inventario.add(item);
    }
    
    public void removerItem(Item item){
        this.inventario.remove(item);
    }
    
    public Item itemMaisPopular(){
        int maiorQuantidade = 0;
        Item item = new Item(0,"Sem Itens");
        for(int i=0; i<inventario.size(); i++){
            if (this.inventario.get(i).getQuantidade() > maiorQuantidade){
                maiorQuantidade = this.inventario.get(i).getQuantidade();
                item = this.inventario.get(i);
            }
        }
        return item;
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
        /*Collections.sort(this.inventario, new Comparator<Item>()
        {
            public int compare(Item item1, Item item2){
                 return Integer.compare(item1.getQuantidade(), item2getQuantidade());
            }
        });*/                     
    }
    
    public boolean equals(Object obj){
        Inventario outro = (Inventario)obj;
        boolean iguais = false;
        if(this.inventario != null && outro != null
            && this.inventario.size()==outro.getLista().size()){
            for(int i=0;i<this.inventario.size();i++){
                Item outroItem = this.inventario.get(i);
                iguais = outro.getLista().contains(outroItem); 
            }
            for(int i=0;i<outro.getLista().size();i++){
                Item outroItem = outro.getLista().get(i);
                iguais = this.inventario.contains(outroItem); 
            } 
        } else {
            iguais = false;
        }
        return iguais;
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
    
    public ArrayList<Item> getLista(){
        return this.inventario;
    }
}