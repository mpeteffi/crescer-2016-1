import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest
{
   @Test
   public void HobbitCalculaDiferencaArraydeArrays(){
       ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
       arrayDePares.add(new ArrayList<>(Arrays.asList(6, 14))); 
       arrayDePares.add(new ArrayList<>(Arrays.asList(5, 4)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(6, 8)));
       HobbitContador hobbit = new HobbitContador();
       hobbit.calcularDiferenca(arrayDePares);
       assertEquals(66,hobbit.calcularDiferenca(arrayDePares));
   }

   @Test
   public void HobbitCalculaDiferencaArraydeArrays840(){
       ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
       arrayDePares.add(new ArrayList<>(Arrays.asList(15,18))); 
       arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
       arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
       HobbitContador hobbit = new HobbitContador();
       hobbit.calcularDiferenca(arrayDePares);
       assertEquals(840,hobbit.calcularDiferenca(arrayDePares));
   }
}
