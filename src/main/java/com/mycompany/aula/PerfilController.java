/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.aula;

import static com.mycompany.aula.App.leitorDeArquivosPost;
import com.mycompany.aula.model.Post;
import com.mycompany.aula.model.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class PerfilController {

    public Post novoPost;
    private ArrayList<Usuario> Usuarios;
    public ArrayList<Post> listaPost = new ArrayList();
    
    
    @FXML
    private Label textNomeUsuario;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoSenha;
    @FXML
    private TextField campoTelefone;
    @FXML
    private TextField campoDataNascimento;
    @FXML
    private TextField campoFormacao;
    @FXML
    private TextArea textPost;
    @FXML
    private Pane panoCarregamento;
    @FXML
    private Button Carregar;
    @FXML
    private TextField campoInteresse;
    @FXML
    private ListView<String> listaAmigos;

    
    @FXML
    private void buttonPerfil(ActionEvent event) {
        
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
    private void buttonFeed(ActionEvent event) throws IOException {
         App.passagemDeTela("feed");
    }

    @FXML
    private void buttonAutalizarDados(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println(App.leitorDeArquivosPost());
    }

    
    //Cria os POSTS
    @FXML
    private void buttonPostar(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        //Verifica se o campo nome e senha esta vazio
        if(!"".equals(textPost.getText())){
            
            try{
                //Pega a lista de Posts
                listaPost = leitorDeArquivosPost();
        
                 //Cadastra o novo Posts se nao existe um       
                        novoPost = new Post(
                                textPost.getText(),
                                dtf.format(LocalDateTime.now()),
                                App.getUsuario().getId()
                        );

                        listaPost.add(novoPost);
                        App.arquivadorPost(listaPost);
                        listaPost.clear();
                
            } catch(FileNotFoundException e){
                
                //Caso seja o primeiro Posts
                novoPost = new Post(
                        textPost.getText(),
                        dtf.format(LocalDateTime.now()),
                        App.getUsuario().getId()
                );

                listaPost.add(novoPost);
                App.arquivadorPost(listaPost);
                listaPost.clear();
            }
        } 
        else{
            System.out.println("Campos nao prenchidos");
        } 
    }

    @FXML
    private void buttonCarregar(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        //Carrega informacao da tela
        panoCarregamento.setVisible(false);
        
        textNomeUsuario.setText("Olá, "+App.getUsuario().getNome());
        
        //Carrega Lista amigos
        ObservableList<String> items = FXCollections.observableArrayList();
        Usuarios = App.leitorDeArquivosUsuario();
        
        for ( int i = 0; i < Usuarios.size(); i++ ) {
           
            for (int y = 0; y < App.getUsuario().getAmigos().size();y++  ){
                
                if ( Usuarios.get(i).getId() == App.getUsuario().getAmigos().get(y) ){
                    items.add( Usuarios.get(i).getNome() );
                }
            
            }
        }
        listaAmigos.setItems(items);
    }
}
