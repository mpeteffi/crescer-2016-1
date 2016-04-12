public class Personagem
{
    protected String nome;
    protected int experiencia=0; 
    protected double vida;
    protected Inventario bolsa = new Inventario();
    protected Status status = Status.VIVO;

    public Personagem(String nome)
    {
        this.nome=nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public void adicionarItem(Item item){
        this.bolsa.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        this.bolsa.removerItem(item);
    }
    
    public Inventario getInventario(){
        return this.bolsa;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    protected void setStatus(Status status){
        this.status=status;
    }
    
    public double getVida(){
        return this.vida;
    }
}
