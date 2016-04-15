public class NaoPodeAlistarException extends Exception {
    // instance variables - replace the example below with your own
    private int x;

    public NaoPodeAlistarException(){
        super("Elfos do tipo normal não podem ser alistados!");
    }
    
    public NaoPodeAlistarException(String message){
        
        super(message);
    }
}
