public class Elfo extends Personagem{
    private int flechas=42;
    
    public Elfo(String nome){
        super(nome);
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
    
    
}
