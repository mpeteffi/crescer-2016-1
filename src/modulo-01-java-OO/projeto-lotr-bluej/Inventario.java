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
    
}
