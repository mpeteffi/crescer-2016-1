import java.util.*;

public class DicionarioSindarin
{
    public static void main(String[] args){
        HashMap<String, String> dicionarioSindarin = new HashMap<>();
        dicionarioSindarin.put("terra","amar");
        dicionarioSindarin.put("fogo","naur");
        dicionarioSindarin.put("vento","gwaew");
        dicionarioSindarin.put("água","nen");
        dicionarioSindarin.put("coração","gûr");
        
        String terraEmSindarin = dicionarioSindarin.get("terra");
        
        //sobrepor valor "agua"
        dicionarioSindarin.put("água","nîn");
        //remover chave-valor
        dicionarioSindarin.remove("água");
        //está vazio?
        boolean estaVazio = dicionarioSindarin.isEmpty();
        //tamanho de pares
        int tamanhoDePares = dicionarioSindarin.size();
        //contém chave?
        boolean contemAgua = dicionarioSindarin.containsKey("água");
        //contém valor?
        boolean contemNaur = dicionarioSindarin.containsValue("naur");
        
        
        dicionarioSindarin.put("FB","Facebook");
        dicionarioSindarin.put("Ea","Badoo");
        
        for(Map.Entry<String, String> chaveValor : dicionarioSindarin.entrySet()){
            System.out.println("K: " + chaveValor.getKey() + "- V: " + chaveValor.getValue());
        }
        
    }
    
}