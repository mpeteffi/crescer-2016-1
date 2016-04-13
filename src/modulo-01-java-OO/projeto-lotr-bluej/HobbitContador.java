import java.util.*;

public class HobbitContador
{
    public HobbitContador(){}
    
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> array){
        int diferenca=0;
        for(int i=0;i<array.size();i++){
            int num1 = array.get(i).get(0), num2 = array.get(i).get(1),
            produto = num1*num2;
            diferenca += Math.abs(produto - calcularMmc(num1,num2));
        }
        return diferenca;
    }

    public int obterMaiorMultiploDeTresAte(int numero) {
        int maiorMultiplo=0; //varável de retorno não estava inicializada.
                           //array não necessário
        for (int i=numero; i>0; i--) { //o limite é o numero dado em parâmetro.
            if (i % 3 == 0) {
                maiorMultiplo=i;
                break;
                //continue não necessário
            }
        }

        return maiorMultiplo; //multiplos não é int. 
    }
    
    public ArrayList<Integer> obterMultiplosDeTresAte(int numero){
        ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));
        
        for (int i = 1; i <=numero; i++) {  //o limite é o parametro numero
            if (i % 3 == 0){                //break sem sentido aparente
                multiplos.add(i);
            }
        }

        return multiplos;
    }
    
    public static int calcularMmc(int n1, int n2){
        int mmc=1, fator=2;
        while(n1!=1||n2!=1){
                if(n1%fator==0||n2%fator==0){
                    if(n1%fator==0){n1=n1/fator;}
                    if(n2%fator==0){n2=n2/fator;}
                    mmc=mmc*fator;
                }else{fator++;}
        }
        return mmc;
    }
}
