import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest
{
   @Test
   public void hobbitCalculaDiferencaArraydeArrays(){
       ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
       arrayDePares.add(new ArrayList<>(Arrays.asList(6, 14))); 
       arrayDePares.add(new ArrayList<>(Arrays.asList(5, 4)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(6, 8)));
       HobbitContador hobbit = new HobbitContador();
       hobbit.calcularDiferenca(arrayDePares);
       assertEquals(66,hobbit.calcularDiferenca(arrayDePares));
   }

   @Test
   public void hobbitCalculaDiferencaArraydeArrays840(){
       ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
       arrayDePares.add(new ArrayList<>(Arrays.asList(15,18))); 
       arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
       HobbitContador hobbit = new HobbitContador();
       hobbit.calcularDiferenca(arrayDePares);
       assertEquals(840,hobbit.calcularDiferenca(arrayDePares));
   }
   
   @Test
   public void retornarMaiorMultiploDeTres(){
       HobbitContador bolseiro = new HobbitContador();
       assertEquals(bolseiro.obterMaiorMultiploDeTresAte(10),9);
       assertEquals(bolseiro.obterMaiorMultiploDeTresAte(100),99);
       assertEquals(bolseiro.obterMaiorMultiploDeTresAte(29),27);
   }
    
    @Test
   public void retornarMultiplosDeTresAte(){
       HobbitContador bolseiro = new HobbitContador();
       ArrayList<Integer> esperado = new ArrayList<>(Arrays.asList(0));
       esperado.add(3);
       esperado.add(6);
       esperado.add(9);
       assertEquals(bolseiro.obterMultiplosDeTresAte(10),esperado);
       esperado.add(12);
       esperado.add(15);
       assertEquals(bolseiro.obterMultiplosDeTresAte(17),esperado);
    }
}
