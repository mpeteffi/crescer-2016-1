'use strict';

function daisyGame(numeroPetalas){
    if(numeroPetalas !== null){
      var ehNumero = (typeof numeroPetalas === 'number');
      var ehNatural = (numeroPetalas%1 === 0 && numeroPetalas>0);
      if(ehNumero && ehNatural){
        return numeroPetalas%2===0 ? 'Love Me Not' : 'Love Me';
      }
    }
  return ("Por favor, insira um número natural.");
}

function maiorTexto(lista) {
    var tamanho = 0;
    for (var i=0; i<lista.length; i++){
        var palavra = lista[i];
        if(palavra.length > tamanho){
        tamanho = palavra.length;
        var index = i;}
    }
    return (lista[index] + " com " + tamanho + " letras.")
}
