package focuscursos.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import focuscursos.controller.navegacao.NavegacaoTelas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginViewController {

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField inputEmail;

    @FXML
    private PasswordField inputSenha;
    
    @FXML
    private BorderPane painelLogin;
    
    @FXML
    void realizarLogin(ActionEvent event) {
    	
    }
    
    

}
