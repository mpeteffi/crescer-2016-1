public class CestoDeLembas {
    private int lembas;
    
    public CestoDeLembas(int lembas){
        this.lembas=lembas;       
    } 
    
    public boolean podeDividirEmPares(){
        if((this.lembas)%2==0 && (this.lembas/3)>=1 && (this.lembas/3)<=100){
           return true;
        } else { return false;}
    }
}