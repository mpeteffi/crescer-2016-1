import java.util.ArrayList;

public class Dwarf {
    private String nome;
    private int vida=110, experiencia=0;
    private Status status = Status.VIVO;
    private Inventario bolsa = new Inventario();
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome){ 
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    
    public Dwarf(String nome, DataTerceiraEra data){ 
        this(nome);
        this.dataNascimento = data;
    }
    
    public void perderVida(){
        double sorte = getNumeroSorte();
        if (sorte < 0){
            this.experiencia += 2;
        }
        if (sorte>100){
            if (this.vida > 0){
                this.vida -= 10;
            } 
            if (this.vida <= 0){
                this.vida=0;
                this.status = Status.MORTO;
            }
        }
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public void adicionarItem(Item item){
        this.bolsa.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        this.bolsa.removerItem(item);
    }
    
    public double getNumeroSorte(){
        double n = 101.0;  
        if (this.dataNascimento.ehBissexto() && 80<=this.vida && 90>=this.vida){
            double num=n*(-33); 
            return num;
        }
        boolean verificaNome = this.nome=="Seixas" || this.nome=="Meireles";    
        if (this.dataNascimento.ehBissexto()==false && verificaNome){
            n=n*33%100;
        }
        return n;
    }
    
    public void tentarSorte(){
        if (getNumeroSorte()==-3333){            
            for(int i=0; i<this.bolsa.getLista().size(); i++){
                int q = this.bolsa.getLista().get(i).getQuantidade();
                q += 1000;
                this.bolsa.getLista().get(i).setQuantidade(q);
            }
        }
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Inventario getInventario(){
        return this.bolsa;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public DataTerceiraEra getNascimento(){
        return this.dataNascimento;
    }
}

