import java.util.ArrayList;

public class ElfoNoturno extends Elfo {
    
    public ElfoNoturno(String nome){ 
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas){ 
        super(nome, flechas);
    }
    
    public void atirarFlecha(Dwarf gimli){
            super.atirarFlecha(gimli);
            experiencia=experiencia+2;
            this.vida = this.vida*0.95; 
            if((int)this.vida<=0){
                this.status=Status.MORTO;
            }
             
            /*A partir da pergunta da questão 7.2, cabe ressaltar que calcular
              decaimento de valores a partir de subtrações recorrentes por uma
              mesma fração do número, resulta numa série numérica que, embora 
              converga para zero, só alcança o valor na quantidade de infinitas
              subtrações. Desta forma, considerando a impossibilidade de infinitas
              operações e desconsiderando o arredondamento de valores que possivelmente
              possam ser feitas pelo sistema, o Elfo Noturno nunca morre por atirar
              flechas.*/
              
            /*Para o item 7.3, correção sugerida para o cálculo da nova vida do Elfo, 
              após atirar uma flecha, é o uso do valor de (int)this.vida para "arredondar"
              de double para int. Dessa forma, é possível que o elfo morra em algum momento
              ((int)this.vida<=0).*/
    } 
    
}

