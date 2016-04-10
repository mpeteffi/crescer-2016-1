import java.util.*;

public class HobbitContador
{
    public HobbitContador(){}
    
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> array){
        int diferenca=0;
        for(int i=0;i<array.size();i++){
            int produto=0, mmc=1, fator=2,
            n1 = array.get(i).get(0),
            n2 = array.get(i).get(1);
            //calcular produto
            produto = n1*n2;
            //calcular mmc
            while(n1!=1||n2!=1){
                if(n1%fator==0||n2%fator==0){
                    if(n1%fator==0){n1=n1/fator;}
                    if(n2%fator==0){n2=n2/fator;}
                    mmc=mmc*fator;
                }else{fator++;}
            }
            //calcular diferença entre produto e mmc
            diferenca += Math.abs(produto - mmc);
        }
        return diferenca;
    }

}
