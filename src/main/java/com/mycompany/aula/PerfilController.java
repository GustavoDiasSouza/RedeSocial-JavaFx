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
    private Label labelNome;
    @FXML
    private Label labelSenha;
    @FXML
    private Label labelFormacao;
    @FXML
    private Label labelTelefone;
    @FXML
    private Label labelData;
    @FXML
    private Label labelInteresses;
    @FXML
    private Label labelAviso;
    @FXML
    private ListView<String> listaInteresses;

    
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

        
        if ( !"".equals(campoNome.getText() ) ){
            App.getUsuario().setNome( campoNome.getText() );
        }
        if ( !"".equals(campoSenha.getText() ) ){
            App.getUsuario().setSenha( campoSenha.getText() );
        }
        if ( !"".equals(campoTelefone.getText() ) ){
            App.getUsuario().setTelefone(campoTelefone.getText() );
        }
        if ( !"".equals(campoDataNascimento.getText() ) ){
           App.getUsuario().setDataNascimento(campoDataNascimento.getText() );
        }
        if ( !"".equals(campoFormacao.getText() ) ){
           App.getUsuario().setFormacao(campoFormacao.getText() );
        }
  
        Usuarios = App.leitorDeArquivosUsuario();
        
        for ( int i = 0; i < Usuarios.size(); i++ ) {
            
            if ( Usuarios.get(i).getId() == App.getUsuario().getId() ){
                Usuarios.remove(i);
                Usuarios.add(App.getUsuario());
                App.arquivadorUsuario(Usuarios);
            }
        }
        
        //Limpa os campos
        campoNome.setText("");
        campoSenha.setText("");
        campoTelefone.setText("");
        campoDataNascimento.setText("");
        campoFormacao.setText("");
        
        //Atualiza o campo
        textNomeUsuario.setText("Olá, "+App.getUsuario().getNome());
        labelNome.setText("Nome: "+App.getUsuario().getNome());
        labelSenha.setText("Senha: "+App.getUsuario().getSenha());       
        labelFormacao.setText("Formação: "+App.getUsuario().getFormacao());
        labelData.setText("Data de Nascimento: "+App.getUsuario().getDataNascimento());
        labelTelefone.setText("Telefone: "+App.getUsuario().getTelefone());
        
        
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
        textPost.setText("");
    }
    
    @FXML
    private void buttonCarregar(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        //Carrega informacao da tela
        panoCarregamento.setVisible(false);
        
        textNomeUsuario.setText("Olá, "+App.getUsuario().getNome());
        labelNome.setText("Nome: "+App.getUsuario().getNome());
        labelSenha.setText("Senha: "+App.getUsuario().getSenha());       
        labelFormacao.setText("Formação: "+App.getUsuario().getFormacao());
        labelData.setText("Data de Nascimento: "+App.getUsuario().getDataNascimento());
        labelTelefone.setText("Telefone: "+App.getUsuario().getTelefone());
        

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
        
        //Carrega os interesses
        ObservableList<String> itemsInteresse = FXCollections.observableArrayList();
                    
        for (int x = 0; x < App.getUsuario().getInterresses().size(); x++ ) {

            itemsInteresse.add(App.getUsuario().getInterresses().get(x));
        }
        listaInteresses.setItems(itemsInteresse);
    }

    @FXML
    private void buttonAdicionaInteresse(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
         if ( !"".equals(campoInteresse.getText() ) ){
            App.getUsuario().setInterresses(campoInteresse.getText() );
            
            Usuarios = App.leitorDeArquivosUsuario();
            for ( int i = 0; i < Usuarios.size(); i++) {
                
                if ( Usuarios.get(i).getId() == App.getUsuario().getId() ){
                    Usuarios.remove(i);
                    Usuarios.add(App.getUsuario());
                    App.arquivadorUsuario(Usuarios);
                    
                    //Atualiza a lista de Interesse
                    ObservableList<String> items = FXCollections.observableArrayList();
                    
                    for (int x = 0; x < App.getUsuario().getInterresses().size(); x++ ) {
                        
                        items.add(App.getUsuario().getInterresses().get(x));
                    }
                    listaInteresses.setItems(items);
                }
            }
            campoInteresse.setText("");
         }
    }

    @FXML
    private void buttonRemoveInteresse(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        if ( !"".equals(campoInteresse.getText() ) ){
            
            for ( int i = 0; i < App.getUsuario().getInterresses().size(); i++ ){
                
                if ( campoInteresse.getText().equals(App.getUsuario().getInterresses().get(i)) ){
                    
                    App.getUsuario().removeInteresse(i);
                    
                    Usuarios = App.leitorDeArquivosUsuario();
                    
                    for ( int y = 0; y < Usuarios.size(); y++) {

                        if ( Usuarios.get(y).getId() == App.getUsuario().getId() ){
                            Usuarios.remove(y);
                            Usuarios.add(App.getUsuario());
                            App.arquivadorUsuario(Usuarios);

                            //Atualiza a lista de Interesse
                            ObservableList<String> items = FXCollections.observableArrayList();

                            for (int x = 0; x < App.getUsuario().getInterresses().size(); x++ ) {

                                items.add(App.getUsuario().getInterresses().get(x));
                            }
                            listaInteresses.setItems(items);
                        }
                    }
                }
            }
            campoInteresse.setText("");
         }
    }
}
