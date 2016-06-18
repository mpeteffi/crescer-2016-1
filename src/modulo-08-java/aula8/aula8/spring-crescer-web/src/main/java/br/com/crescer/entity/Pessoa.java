/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controllers;

import java.util.Date;

/**
 *
 * @author murillo.peteffi
 */
public class Pessoa {
    
    private Date nascimento;
    private String nome;

    public String getNome() {
        return nome;
    }
    
    public void setNascimento(Date Nascimento) {
        this.nascimento = Nascimento;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }
}
