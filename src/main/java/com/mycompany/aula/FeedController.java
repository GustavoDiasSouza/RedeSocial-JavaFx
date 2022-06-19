/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.aula;

import com.mycompany.aula.model.Post;
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
public class FeedController {
    
    private ArrayList<Post> Post;
    private ArrayList<Integer> ListAmigos;
    private ArrayList<Usuario> Usuarios;

    
    @FXML
    private Label textNomeUsuario;
    @FXML
    private Button Carregar;
    @FXML
    private Pane panoCarregamento;
    @FXML
    private ListView<String> listaPosts;


    @FXML
    private void buttonPerfil(ActionEvent event) throws IOException {
         App.passagemDeTela("perfil");
        
    }

    @FXML
    private void buttonBusca(ActionEvent event) throws IOException {
        App.passagemDeTela("busca");
    }
    
     @FXML
    private void buttonFeed(ActionEvent event) {
    }

    @FXML
    private void Sair(ActionEvent event) throws IOException {
        App.passagemDeTela("login");
    }

    
    
    //Carrega tela
    @FXML
    private void buttonCarregar(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        //Carrega informacao da tela
        panoCarregamento.setVisible(false);
        textNomeUsuario.setText("Olá, "+App.getUsuario().getNome());
        
        try{
            //Lista de Posts
            ObservableList<String> items = FXCollections.observableArrayList ();

            Post = App.leitorDeArquivosPost();
            ListAmigos = App.getUsuario().getAmigos();
            Usuarios = App.leitorDeArquivosUsuario();

            //Percore post de traz para frente, pegando do ultimo post ate o mais atual
            for(int i = Post.size()-1; i >= 0; i-- ){

                //Percore a lista de amigos do usuario
                for(int y = 0; y < ListAmigos.size(); y++ ){

                    if( ListAmigos.get(y) == Post.get(i).getIdUsuario() ){

                        //Percore os usuarios para compara o id com o nome
                        for (int h = 0; h < Usuarios.size(); h++){

                            if( ( Usuarios.get(h).getId() == Post.get(i).getIdUsuario() ) || ( Post.get(i).getIdUsuario() == App.getUsuario().getId() ) ){
                                 String nome = Usuarios.get(h).getNome();

                                items.add(nome+": "+Post.get(i).getConteudo()+"\nPostado Em: "+Post.get(i).getTimeStamp());
                            }
                        }
                    }     
                }

                if( Post.get(i).getIdUsuario() == App.getUsuario().getId() ){
                    String nome = App.getUsuario().getNome();

                    items.add(nome+": "+Post.get(i).getConteudo()+"\nPostado Em: "+Post.get(i).getTimeStamp());
                }
            }

                listaPosts.setItems(items);
        }
        catch(FileNotFoundException e){
            System.out.println("Nenhum post ainda");
        }
    }  
}
