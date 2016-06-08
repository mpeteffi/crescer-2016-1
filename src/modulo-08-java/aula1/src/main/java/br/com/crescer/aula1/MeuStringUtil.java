package br.com.crescer.aula1;
import java.text.Collator;
import java.util.Locale;

/**
 * @author Murillo
 */
public class MeuStringUtil {
    
    public static void main(String[] args){
        System.out.println("Funções disponíveis: \n ehVazia()\n quantidadeVogais()\n inverter()\n ehPalindromo()");
    }
    
    public boolean ehVazia(String aString){
        
        return aString.isEmpty() || aString.trim().length() == 0;
    } 
   
    public int quantidadeVogais(String aString){
        
        int quantidadeVogais = 0;
        String vogais = "aeiou";
        for(char c : aString.toLowerCase().toCharArray()){
            if(vogais.indexOf(c) >= 0){
                quantidadeVogais++;
            }
        }
        
        return quantidadeVogais;
    }

    public String inverter(String aString){
        
        return new StringBuilder(aString).reverse().toString();
    }
    
    public boolean ehPalindromo(String aString){
    
        /* stackoverflow.com/questions/28833797/compare-strings-ignoring-accented-characters */
        /* guj.com.br/t/comparar-strings-com-e-sem-acento/35545/21 */
        final Collator collator = Collator.getInstance(new Locale("pt", "BR"));
        collator.setStrength(Collator.NO_DECOMPOSITION);

        return collator.compare(aString.trim().toLowerCase(), inverter(aString).trim().toLowerCase()) == 0;
    }
}
