package com.mycompany.aula;

import com.mycompany.aula.model.Post;
import com.mycompany.aula.model.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    private static Usuario usuario;
    
    private static ArrayList<Usuario> Usuarios;
    
    private static ArrayList<Post> Posts;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        App.usuario = usuario;
    }
    
    
    //Telas
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml, Usuario usuario) throws IOException {
        scene.setRoot(loadFXML(fxml));
        App.setUsuario(usuario);

    }
    
    static void passagemDeTela(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
    
    
    
    //Controladores_de_Arquivo do Usuario
    public static void arquivadorUsuario(ArrayList<Usuario> novoUsuario) throws FileNotFoundException, IOException{   
        
        FileOutputStream fOut = new FileOutputStream("Usuarios.ser");
        
        try (ObjectOutputStream oOut = new ObjectOutputStream(fOut)) {
            
            oOut.writeObject(novoUsuario);
        }
        
    };
    
    public static ArrayList<Usuario> leitorDeArquivosUsuario() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        FileInputStream fInput = new FileInputStream("Usuarios.ser");
        
        try (ObjectInputStream obInput = new ObjectInputStream(fInput)) {
            
            Usuarios = (ArrayList<Usuario>) obInput.readObject();
            
        } catch (FileNotFoundException  e) {
            
            System.out.println("Arquivo nao encontrado");
        }
        
        return  Usuarios;
    }
    
    //Controladores_de_Arquivo dos Posts
    public static void arquivadorPost(ArrayList<Post> novoPost) throws FileNotFoundException, IOException{   
        
        FileOutputStream fOut = new FileOutputStream("Posts.ser");
        
        try (ObjectOutputStream oOut = new ObjectOutputStream(fOut)) {
            
            oOut.writeObject(novoPost);
        }
        
    };
    
    public static ArrayList<Post> leitorDeArquivosPost() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        FileInputStream fInput = new FileInputStream("Posts.ser");
        
        try (ObjectInputStream obInput = new ObjectInputStream(fInput)) {
            
            Posts = (ArrayList<Post>) obInput.readObject();
            
        } catch (FileNotFoundException  e) {
            
            System.out.println("Arquivo nao encontrado");
        }
        
        return  Posts;
    }
    
    
    
    

}