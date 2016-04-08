public class Dwarf {
    private String nome;
    private int vida=110;
    private Status status = Status.VIVO;
    public Inventario bolsa = new Inventario();
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome){ 
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    
    public Dwarf(String nome, DataTerceiraEra data){ 
        this.nome = nome;
        this.dataNascimento = data;
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
            n=n*33;
            n=n%100;
        }
        
        return n;
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
    
    public DataTerceiraEra getNascimento(){
        return this.dataNascimento;
    }
}

