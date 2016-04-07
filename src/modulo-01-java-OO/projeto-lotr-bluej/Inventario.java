import java.util.ArrayList;

public class Inventario
{
    private ArrayList<String> inventario = new ArrayList<>();
    private String item;

    public Inventario(){
        
    }

    public void adicionarItem(String item){
        this.inventario.add(item);
    }
    
    public void removerItem(String item){
        this.inventario.remove(item);
    }
    
   // public int getItem(String item){
    //int a;
    
     //  for (int i=0;i<=9;i++){
     //      if (this.inventario[i]==item)
     //  }
        
     //  return this.inventario(item);
   // }
    
}
