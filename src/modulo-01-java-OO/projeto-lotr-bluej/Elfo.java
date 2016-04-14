public class Elfo extends Personagem{
    protected int flechas=42;
    
    public Elfo(String nome){
        super(nome);
        this.vida=100;
        this.quantidadeElfos++;
    }
    
    public Elfo(String nome, int flechas){
        this(nome);
        this.flechas = flechas;
    }
    
    protected void finalize() throws Throwable {
        this.quantidadeElfos--;
        super.finalize();
    }
    
    public void atirarFlecha(Dwarf gimli){
            this.flechas--;
            this.experiencia++;
            gimli.perderVida();
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
    
    public int getFlechas(){
        return this.flechas;
    }
    
    public void tentarSorte(){
        System.out.println("Elfo tentou a sorte!");
    }
}
