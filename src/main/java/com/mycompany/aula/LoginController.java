/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.aula;

import com.mycompany.aula.model.Usuario;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class LoginController implements Initializable {


    public Usuario admin;
    public ArrayList<Usuario> lista = new ArrayList();
    
    private short instanciaAdmin = 0;
    
    @FXML
    private Button Entrar;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField CampoSenha;
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    
    
    @FXML
    private void buttonEntrar(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        //Criar_Novos_Usuarios
        if( "admin".equals(campoNome.getText()) && "UFP31".equals(CampoSenha.getText()) ){
            App.passagemDeTela( "novosUsuarios");
        } else {
            
            try{
                lista = App.leitorDeArquivosUsuario();    
            }catch(FileNotFoundException  e){
                System.out.println("Nenhum usuario criado ainda");
            }

            for (int i = 0; i < lista.size(); i ++) {
               
                //Encontrou um usuario
                if ( lista.get(i).getNome().equals(campoNome.getText()) && (lista.get(i).getSenha()).equals(CampoSenha.getText())){
                    App.setRoot("feed",lista.get(i));
                }
            }  
        }
    }
    
    
    
    @FXML
    private void Sair(ActionEvent event) {
        System.exit(0);
    }

}
