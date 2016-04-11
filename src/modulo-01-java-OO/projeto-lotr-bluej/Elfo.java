public class Elfo{
    private String nome;
    private int experiencia, flechas=42;
    protected Inventario bolsa = new Inventario();
    
    public Elfo(String nome){
        this.nome = nome;
    }
    
    public Elfo(String nome, int flechas){
        this(nome);
        this.flechas = flechas;
    }
    
    public void atirarFlecha(Dwarf gimli){
            flechas--;
            experiencia++;
            gimli.perderVida();
            } 
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public int getFlechas(){
        return this.flechas;
    }
    
    public String toString(){
        
        boolean flechaNoSingular = Math.abs(this.flechas) == 1;
        boolean experienciaNoSingular = Math.abs(this.experiencia) == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência.", 
            this.nome,
            this.flechas,
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis");
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
}
