public class Elfo{
    private String nome;
    private int experiencia, flechas=42;
    
    public Elfo(String nome){
        this.nome = nome;
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
        return this.nome + " possui " + this.flechas + " flechas e " + this.experiencia + " níveis de experiência.";
    }
}
