'use strict';

function daisyGame(numeroPetalas){
    ehNumero = typeof numeroPetalas === 'number';
    ehInteiro = numeroPetalas%1 === 0;
    if(ehNumero && ehInteiro)
    return numeroPetalas%2===0 ? 'Love Me Not' : 'Love Me';
    else return ("Por favor, insira um número natural.")
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
