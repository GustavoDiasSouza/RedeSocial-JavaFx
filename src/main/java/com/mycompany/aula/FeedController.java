/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.aula;

import com.mycompany.aula.model.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class FeedController implements Initializable {
    
    private ArrayList<Usuario> Usuarios;

    
    @FXML
    private Label textNomeUsuario;
    @FXML
    private Button Carregar;
    @FXML
    private Pane panoCarregamento;
    @FXML
    private ListView<String> listaPosts;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    

    @FXML
    private void buttonPerfil(ActionEvent event) throws IOException {
         App.passagemDeTela("perfil");
        
    }

    @FXML
    private void buttonBusca(ActionEvent event) throws IOException {
        App.passagemDeTela("busca");
    }

    @FXML
    private void Sair(ActionEvent event) throws IOException {
        App.passagemDeTela("login");
    }

    @FXML
    private void buttonFeed(ActionEvent event) {
    }
    
    
    
    @FXML
    private void buttonCarregar(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        //Carrega informacao da tela
        panoCarregamento.setVisible(false);
        
        textNomeUsuario.setText("Olá, "+App.getUsuario().getNome());
        
        //Lista
        ObservableList<String> items = FXCollections.observableArrayList ();
        Usuarios = App.leitorDeArquivosUsuario();
        
        for(int i = 0; i < Usuarios.size(); i++ ){
            items.add(Usuarios.get(i).getNome());
        }
        
        listaPosts.setItems(items);
        
    }
}
