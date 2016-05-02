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
        var naoEhNull = palavra !== null;
        var ehString = typeof palavra === "String";
        if(naoEhNull && ehString && palavra.length > tamanho){
          tamanho = palavra.length;
        var index = i;}
    }
    if(tamanho>0) {
    return ("A maior palavra é " + lista[index] + " com " + tamanho + " caracteres.");}
    else { return ("Nenhuma String encontrada no Array informado.");}
}
