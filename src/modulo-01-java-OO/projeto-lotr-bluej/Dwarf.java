public class Dwarf {
    private String nome;
    private int vida=110;
    private Status status = Status.VIVO;
    
    public Dwarf(String nome){ 
        this.nome = nome;
    }
    
    public void perderVida(){
        if (this.vida > 0){
            this.vida -= 10;
        } 
        
        if (this.vida <= 0){
            this.vida=0;
            this.status = Status.MORTO;
        }
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
}

