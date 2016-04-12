import java.util.ArrayList;

public class Dwarf extends Personagem{
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome){ 
        super(nome);
        this.vida=110;
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
    
    public DataTerceiraEra getNascimento(){
        return this.dataNascimento;
    }
    
    public static Dwarf descobrirMenosVida(Dwarf d1, Dwarf d2){
        return d1.getVida()<d2.getVida() ? d1 : d2;
    }
}

