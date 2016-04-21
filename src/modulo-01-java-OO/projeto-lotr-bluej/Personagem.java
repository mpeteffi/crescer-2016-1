public abstract class Personagem
{
    protected String nome;
    protected int experiencia; 
    protected double vida;
    protected Inventario bolsa = new Inventario();
    protected Status status = Status.VIVO;
    protected static int quantidadeElfos;

    public Personagem(String nome)
    {
        this.nome=nome;
    }
    
    public void adicionarItem(Item item){
        this.bolsa.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        this.bolsa.removerItem(item);
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public Inventario getInventario(){
        return this.bolsa;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public abstract void tentarSorte();

}
