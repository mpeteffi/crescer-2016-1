import java.util.*;

public class DicionarioSindarin
{
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao Tradutor Sindarin! \nEscolha a linguagem: ");
        System.out.println("[P]ortuguês [I]nglês");
        String idioma = scanner.nextLine();
        TradutorSindarin tradutor = criarTradutor(idioma);
        System.out.println("Digite a palavra a ser traduzida: ");
        String palavra = scanner.nextLine();
        System.out.println(palavra + " significa " + tradutor.traduzir(palavra));
        
    }
        
    private static TradutorSindarin criarTradutor(String string){
        switch(string.toLowerCase()){
            case "i":
                return new SindarinParaIngles();
            default:
                return new SindarinParaPortugues();
        }
    }
    
}