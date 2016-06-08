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
    
        /* stackoverflow.com/questions/16558898/get-difference-between-two-dates-in-months-using-java */
        Calendar inicioContagem = new GregorianCalendar();
        inicioContagem.setTime(data);
        Calendar dataAtual = new GregorianCalendar();
        dataAtual.setTime(new Date());

        int ano = dataAtual.get(Calendar.YEAR) - inicioContagem.get(Calendar.YEAR);
        int mes = dataAtual.get(Calendar.MONTH) - inicioContagem.get(Calendar.MONTH);
        int dia = dataAtual.get(Calendar.DAY_OF_MONTH) - inicioContagem.get(Calendar.DAY_OF_MONTH);
        if(dia < 0){ mes--; dia = 30 - dia; }
        if(mes < 0){ ano--; mes = 12 - mes; }
                
        return new StringBuilder("Já se passaram ")
                .append(ano).append(" Anos ")
                .append(mes).append(" meses e ")
                .append(dia).append(" dias.")
                .toString();
    }    
}


