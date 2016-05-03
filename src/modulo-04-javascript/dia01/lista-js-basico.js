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

function fiboSum(n) {
  var ehNumeroNatural = (n!=null && typeof n === 'number' && !isNaN(n) && n%1===0 && n>0);
  if(ehNumeroNatural){
    var soma = 0;
    var atual = 1;
    var anterior = 1;
    for (var i=1; i<=n; i++){
      if (i<=2){
        soma += 1;
      } else {
        atual += anterior;
        soma += atual;
        anterior = atual - anterior;
      }
    }
    return soma;
  } else{
    return ("Informe um número natural como parâmetro.");
  }
}

function queroCafe(mascada, precos){
  var ehNumero = (mascada!=null && typeof mascada === 'number' && !isNaN(mascada));
  var ehArray = Array.isArray(precos);
  if(ehNumero && ehArray){
    var qtdPrecos = 0;
    var arrayFinal = [];
    for(var i=0; i<precos.length; i++){
      var oPreco = precos[i];
      var ehPrecoValido = (oPreco!=null && typeof oPreco === 'number' && !isNaN(oPreco));
      if(ehPrecoValido){
        qtdPrecos++;
        if(oPreco<=mascada){
          arrayFinal.push(oPreco);
        }
      }
    }
    if(qtdPrecos>0){
      if(arrayFinal.length > 0){
        arrayFinal.sort(function(a, b){return a-b});
        return arrayFinal;
      } else {
        return ("Mascada insuficiente para comprar café.")
      }
    } else {
      return ("Nenhum preço válido encontrado na Array informada.");
    }
  } else {
    return ("Insira o valor da mascada e um array de preços, nesta ordem.");
  }
}

function contarPorTipo(obj, stringInformada){
  var stringsValidas = ['string','number','boolean','object','undefined','null','function','array'];
  var ehObjeto = typeof obj === 'object';
  var ehStringValida = stringsValidas.includes(stringInformada);
  if(ehObjeto && ehStringValida){
    var qtdDoTipo = 0;
    for (var i in obj){
      if(stringInformada === 'null'){
        if(obj[i] === null){
          qtdDoTipo++;
        }
      }
      if(stringInformada === 'array'){
        if(obj[i] instanceof Array){
          qtdDoTipo++;
        }
      }
      if(typeof obj[i] === stringInformada){
        qtdDoTipo++;
      }
    }
    if(qtdDoTipo>0){
      return qtdDoTipo;
    } else {
      return ("Nenhuma propriedade do objeto é do tipo informado.")
    }
  } else {
    return ("Informe um objeto complexo e uma string válida, nesta ordem.")
  }
}
