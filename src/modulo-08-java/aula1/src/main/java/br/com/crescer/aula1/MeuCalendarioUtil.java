package br.com.crescer.aula1;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Murillo
 */
public class MeuCalendarioUtil {
    
    public static void main(String[] args){
    
        System.out.println("Funções disponíveis: \n diaDaSemana()\n tempoDecorrido()");
    }
    
    public String diaDaSemana(Date data){
        
        SimpleDateFormat formatacao = new SimpleDateFormat("EEEE"); 
        return formatacao.format(data); 
    }
    
    public String tempoDecorrido(Date data){
    
        /* stackoverflow.com/questions/13084651/java-method-to-find-difference-between-2-date-objects-in-years-months-and-days */
        //Date dataAtual = new Date();        
        //long diferenca = dataAtual.getTime() - data.getTime();

        //Date resultado = new Date(diferenca);
        //SimpleDateFormat d = new SimpleDateFormat("dd");
        //SimpleDateFormat m = new SimpleDateFormat("MM");
        //SimpleDateFormat a = new SimpleDateFormat("yy");
        
        //String dia = d.format(resultado);
        //String mes = m.format(resultado);
        //String ano = a.format(resultado);
        
        //return new StringBuilder("Já se passaram ")
                //.append(ano).append(" Anos ")
                //.append(mes).append(" meses e ")
                //.append(dia).append(" dias.")
                //.toString();
    }    
}


