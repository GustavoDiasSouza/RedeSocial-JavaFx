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
public class BuscaController implements Initializable {
    
    private ArrayList<Usuario> Usuarios;

    @FXML
    private Label textNomeUsuario;
    @FXML
    private ListView<String> listaBusca;
    @FXML
    private Pane panoCarregamento;
    @FXML
    private Button Carregar;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonPerfil(ActionEvent event) throws IOException {
         App.passagemDeTela("perfil");
    }

    @FXML
    private void buttonBusca(ActionEvent event) {
    }

    @FXML
    private void Sair(ActionEvent event) throws IOException {
        App.passagemDeTela("login");
    }

    @FXML
    private void buttonFeed(ActionEvent event) throws IOException {
         App.passagemDeTela("feed");
    }

    @FXML
    private void pesquisarInteresse(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
       
        ObservableList<String> items = FXCollections.observableArrayList();
        
        Usuarios = App.leitorDeArquivosUsuario();
        
        for(int i = 0; i < Usuarios.size(); i++ ){
            items.add(Usuarios.get(i).getNome()+Usuarios.get(i).getId());
        }
        
        listaBusca.setItems(items);
        
    }

    @FXML
    private void buttonCarregar(ActionEvent event) {
        
        //Carrega informacao da tela
        panoCarregamento.setVisible(false);
        
        textNomeUsuario.setText("Olá, "+App.getUsuario().getNome());
        
        
    }
    
}
