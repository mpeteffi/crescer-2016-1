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
            this.vida-=5; 
            if(this.vida==0){
                setStatus(Status.MORTO);
            }
           
            /*Para a questão 7.1, o mais correto seria a variável vida estar em double, 
              na definição, e praticamente todos os metodos e classes deveriam ser alteradas.
              Porém, considerando que o método é inconsistente de qualquer maneira,
              mantenho assim para alterar no próximo commit. */
             
            /*A partir da pergunta da questão 7.2, cabe ressaltar que calcular
              decaimento de valores a partir de subtrações recorrentes por uma
              mesma fração do número, resulta numa série numérica que, embora 
              converga para zero, só alcança o valor na quantidade de infinitas
              subtrações. Desta forma, considerando a impossibilidade de infinitas
              operações e desconsiderando o arredondamento de valores que possivelmente
              possam ser feitas pelo sistema, o Elfo Noturno nunca morre por atirar
              flechas.*/
              
            /*Para o item 7.3, correção sugerida para o cálculo da nova vida do Elfo, 
              após atirar uma flecha, é o uso do valor percentual de 5% em relação à 
              vida inicial do mesmo (100), de modo a podermos usar int e retirar 5 pontos 
              a cada flechada. Dessa forma, é possível que o elfo morra em algum momento
              (vida=0).*/
            } 
    
}

