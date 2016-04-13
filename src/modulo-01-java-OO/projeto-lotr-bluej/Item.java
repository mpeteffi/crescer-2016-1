public class Item{
    private int quantidade;
    private String descricao;

    public Item(int quantidade, String descricao){
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public int getQuantidade(){
        return this.quantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade=quantidade;
    }
    
    public boolean equals(Object obj){
        return this.quantidade==((Item)obj).getQuantidade() &&
            this.descricao != null &&
            ((Item)obj) != null &&
            this.descricao==((Item)obj).getDescricao();
    }
}
