public class CestoDeLembas {
    private int lembas;
    
    public CestoDeLembas(int lembas){
        this.lembas=lembas;       
    } 
    
    public boolean podeDividirEmPares(){
        return lembas%2==0 && lembas>=3 && lembas<=100;
        //boolean podeDividir = lembas%2==0 && lembas>=3 && lembas<=100;
        //return podeDividir ? true : false;
    }
}