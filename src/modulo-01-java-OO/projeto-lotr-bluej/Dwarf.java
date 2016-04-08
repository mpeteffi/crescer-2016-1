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

