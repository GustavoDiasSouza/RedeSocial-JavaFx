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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class BuscaController implements Initializable {
    
    private ArrayList<Usuario> Usuarios;
    public ArrayList<Usuario> listSave = new ArrayList();

    @FXML
    private Label textNomeUsuario;
    @FXML
    private ListView<String> listaBusca;
    @FXML
    private Pane panoCarregamento;
    @FXML
    private Button Carregar;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField CampoInteresse;
    @FXML
    private TextField CampoAddUusario;
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
    private void buttonBusca(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
    }

    @FXML
    private void Sair(ActionEvent event) throws IOException {
        App.passagemDeTela("login");
    }

    @FXML
    private void buttonFeed(ActionEvent event) throws IOException {
         App.passagemDeTela("feed");
    }

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
        
        textNomeUsuario.setText("Ol??, "+App.getUsuario().getNome());
        
        
    }

    @FXML
    private void buttonPesquisadoNome(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        ObservableList<String> items = FXCollections.observableArrayList();
        Usuarios = App.leitorDeArquivosUsuario();
        
        
        if( !"".equals(campoNome.getText()) ){
            
            for( int i = 0; i < Usuarios.size(); i++ ){
                
                if( Usuarios.get(i).getNome().equals(campoNome.getText()) ){
                    
                    if( !Usuarios.get(i).getNome().equals( App.getUsuario().getNome() ) ){
                        
                        items.add(Usuarios.get(i).getNome()+"\nInteresses: "+Usuarios.get(i).getInterresses());
                    }
                }
            }
            
            if(items.isEmpty()){
                items.add("N??o encontramos nada");
            }

            listaBusca.setItems(items);
        }
        else {
            
            for( int i = 0; i < Usuarios.size(); i++ ){
                
                     if(!Usuarios.get(i).getNome().equals(App.getUsuario().getNome())){
                        items.add(Usuarios.get(i).getNome()+"\nInteresses: "+Usuarios.get(i).getInterresses());
                    }
            }

            listaBusca.setItems(items);
         
         }
    }

    @FXML
    private void buttonPesquisaInteresse(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        ObservableList<String> items = FXCollections.observableArrayList();
        Usuarios = App.leitorDeArquivosUsuario();
        
        
        
    }

    @FXML
    private void buttonAddUsuario(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        Usuarios = App.leitorDeArquivosUsuario();
        //Percore a lista
        for( int i = 0; i < Usuarios.size(); i++ ){
                
                //Compara o nome do usuario na lista com o nome que esta no campoNome para ver se sao iguais
               if( Usuarios.get(i).getNome().equals(CampoAddUusario.getText()) ){
                        
                        //Percore a lista de amigos do Usuario que esta usando a rede social
                        for ( int x = 0; x < App.getUsuario().getAmigos().size();x++  ){
                            
                            //Compara se esta na lista dos amigos 
                            if( Usuarios.get(i).getId() == App.getUsuario().getAmigos().get(x) ){
                                System.out.println("J?? adiconado a lista de amigos");
                                CampoAddUusario.setText("");
                                return;
                            }
                    }
                    //Chama a fun????o que adiciona
                    adicionaAmigo(i);
                    System.out.println("Amigo adicionado"+App.getUsuario());
                    CampoAddUusario.setText("");
                }
            }
           
    }
    
    public void adicionaAmigo(int i) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        //Adiciona aos amigos
        App.getUsuario().setAmigos(Usuarios.get(i).getId());

        for( int j = 0; j < Usuarios.size(); j++ ){

            if( Usuarios.get(j).getId() == App.getUsuario().getId() ){

                listSave = App.leitorDeArquivosUsuario();
                listSave.remove(j);
                listSave.add(App.getUsuario());
                App.arquivadorUsuario(listSave);
                listSave = App.leitorDeArquivosUsuario();
                listSave.clear();
            }
        }
    
    }
    
}
