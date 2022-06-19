/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Gustavo
 */
public class Usuario implements Serializable  {
    
    private static final long serialVersionUID = 000001;
    private String nome;
    private String email;
    private String senha;
    private String dataNascimento;
    private String telefone;
    private String linkRedeSocial;
    private String formacao;
    private String[] interresses;
    private int[] amigos;
    private int id;

    public Usuario(String nome, String email, String senha, String dataNascimento, String telefone, String formacao, int id) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.formacao = formacao;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", email=" + email + ", senha=" + senha + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + ", linkRedeSocial=" + linkRedeSocial + ", formacao=" + formacao + ", interresses=" + Arrays.toString(interresses) + '}';
    }

    public int[] getAmigos() {
        return amigos;
    }

    public void setAmigos(int[] amigos) {
        this.amigos = amigos;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLinkRedeSocial() {
        return linkRedeSocial;
    }

    public void setLinkRedeSocial(String linkRedeSocial) {
        this.linkRedeSocial = linkRedeSocial;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String[] getInterresses() {
        return interresses;
    }

    public void setInterresses(String[] interresses) {
        this.interresses = interresses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
    
    
    

    
    
    
}
