import java.util.ArrayList;

public class ElfoNoturno extends Elfo {
    
    public ElfoNoturno(String nome){ 
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas){ 
        super(nome, flechas);
    }
    
    public void atirarFlecha(Dwarf gimli){
            this.flechas--;
            experiencia=experiencia+3;
            gimli.perderVida();
            this.vida=vida-((5*this.vida)/100); 
            /*mais correto seria a variável vida estar em double, na definição,
             e praticamente todos os metodos e classes deveriam ser alteradas.
             Porém, considerando que o método é inconsistente de qualquer maneira,
             mantenho assim para alterar no próximo commit. */
            } 
    
}

