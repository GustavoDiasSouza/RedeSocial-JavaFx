/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula.model;

import java.io.Serializable;

/**
 *
 * @author Gustavo
 */
public class Post implements Serializable{
    private String conteudo;
    private String timeStamp;
    private int idUsuario;

    public Post(String conteudo, String timeStamp, int idUsuario) {
        this.conteudo = conteudo;
        this.timeStamp = timeStamp;
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Post{" + "conteudo=" + conteudo + ", timeStamp=" + timeStamp + ", idUsuario=" + idUsuario + '}';
    }
    
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
