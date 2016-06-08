package br.com.crescer.aula1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    
        Calendar diferenca = new GregorianCalendar();
        long diff = new Date().getTime() - data.getTime();
        diferenca.setTime(new Date(diff));
        
        return new StringBuilder("Já se passaram ")
                .append(diferenca.get(Calendar.YEAR) - 1970).append(" Anos ")
                .append(diferenca.get(Calendar.MONTH)).append(" meses e ")
                .append(diferenca.get(Calendar.DAY_OF_MONTH)).append(" dias.")
                .toString();
    }    
}


