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
  if(Array.isArray(lista)){
    var tamanho = 0;
    for (var i=0; i<lista.length; i++){
      var palavra = lista[i];
      var naoEhNull = palavra !== null;
      var ehString = typeof palavra === "string";
      if(naoEhNull && ehString && palavra.length > tamanho){
        tamanho = palavra.length;
        var index = i;}
      }
      if(tamanho>0) {
        return ("A maior palavra é " + lista[index] + " com " + tamanho + " caracteres.");
      } else { return ("Nenhuma String encontrada no Array informado.");
    }
  } else { return ("Favor inserir um Array de Strings como parâmetro");}
}

function imprime (array, fn){
  var ehArray = Array.isArray(array);
  var ehFunction = (typeof fn === "function");
  if(ehArray && ehFunction) {
    var qtdString = 0;
    for(var i=0; i<array.length; i++){
      var ehString = typeof array[i] === "string";
      if(ehString){
        fn(array[i]);
        qtdString++;
      }
    }
    if(qtdString===0){
      return ("Nenhuma String encontrada no Array informado.");
    }
  } else { return ("Você deve informar um Array de Strings e uma Function, nesta ordem.")}
}

function adicionar(a){
  return function(b) {
    var aEhNumero = (a!=null && typeof a === 'number' && !isNaN(a));
    var bEhNumero = (b!=null && typeof b === 'number' && !isNaN(b));
    if(aEhNumero && bEhNumero){
      return a+b;
    } else {return ("Favor informar apenas números como parâmetros.")}
  }
}
