/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.aula;

import static com.mycompany.aula.App.*;
import com.mycompany.aula.model.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Gustavo
 */
public class NovosUsuariosController  {
    
    public Usuario novoUsuario;
    public ArrayList<Usuario> listSave = new ArrayList();
    
    
    @FXML
    private Button criarUsuario;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoSenha;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoTelefone;
    @FXML
    private TextField campoData;
    @FXML
    private TextField campoFormacao;

    
    @FXML
    private void butaoCriarUsuario(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {

        //Verifica se o campo nome e senha esta vazio
        if(!"".equals(campoNome.getText()) && !"".equals(campoSenha.getText())){
            
            try{
                //Pega a lista de Usuarios
                listSave = leitorDeArquivosUsuario();
                
                //Verifica se ja existe algum usuario com o mesmo nome e senha
                for(int i = 0; i < listSave.size(); i++){      
                    if( (campoNome.getText().equals(listSave.get(i).getNome())) && (campoSenha.getText().equals(listSave.get(i).getSenha()))   ){
                         System.out.println("- Usuario ja existe");
                         return ;
                    }
                }
                
                 int id = App.leitorDeArquivosUsuario().size();
                 //Cadastra o novo usuario se nao existe um       
                        novoUsuario = new Usuario(      
                                campoNome.getText(),
                                campoEmail.getText(),
                                campoSenha.getText(),
                                campoData.getText(),
                                campoTelefone.getText(),
                                campoFormacao.getText(),
                                id
                        );
                        
                        listSave.add(novoUsuario);
                        App.arquivadorUsuario(listSave);
                        System.out.println("Novo Cadastrado"+novoUsuario);
                        listSave.clear();
                
            } catch(FileNotFoundException e){
                
                //Caso seja o primeiro cadastro
                novoUsuario = new Usuario(      
                                campoNome.getText(),
                                campoEmail.getText(),
                                campoSenha.getText(),
                                campoData.getText(),
                                campoTelefone.getText(),
                                campoFormacao.getText(),
                                0
                        );

                listSave.add(novoUsuario);
                App.arquivadorUsuario(listSave);
                System.out.println("Primeiro Cadastro: "+novoUsuario);
                listSave.clear();
            }
        } 
        else{
            System.out.println("Campos nao prenchidos");
        } 
    }

    @FXML
    private void sair(ActionEvent event) throws IOException {
        App.passagemDeTela("login");
    }

}
