/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula.model;

import java.io.Serializable;
import java.util.ArrayList;

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
    private ArrayList<String> interesses;
    private ArrayList<Integer> amigos;
    private int id;

    public Usuario(String nome, String email, String senha, String dataNascimento, String telefone, String formacao, int id) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.formacao = formacao;
        this.id = id;
        this.amigos = new ArrayList();
        this.interesses = new ArrayList();
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", email=" + email + ", senha=" + senha + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + ", linkRedeSocial=" + linkRedeSocial + ", formacao=" + formacao + ", interesses=" + interesses + ", amigos=" + amigos + ", id=" + id + '}';
    }

    public ArrayList<Integer> getAmigos() {
        return amigos;
    }

    public void setAmigos(int amigos) {
        this.amigos.add(amigos);
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

    public ArrayList<String> getInterresses() {
        return interesses;
    }
    
    public String retornaListaInteresseString(){
        String lista = "";
        for (int t = 0;  t < this.interesses.size(); t++){
            if ( t == 0 ){
                lista += this.interesses.get(t);
            } 
            else {
                lista += ", "+this.interesses.get(t);
            }
        }
        
        return lista;
    }
    
    public void removeInteresse(int i){
        this.interesses.remove(i);
    } 

    public void setInterresses(String interesses) {
        this.interesses.add(interesses);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
    
    
    

    
    
    
}
