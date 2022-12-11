package focuscursos.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import focuscursos.controller.constantes.Tela;
import focuscursos.controller.navegacao.NavegacaoTelas;
import focuscursos.model.persistencia.ArquivoLogin;
import focuscursos.servicos.LoginServico;
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
    
    private LoginServico servico = new LoginServico();
    
    @FXML
    void realizarLogin(ActionEvent event) {

    	String email = inputEmail.getText();
    	String senha = inputSenha.getText();
    	
    	if(servico.fazerLogin(email, senha)) {
    		try {
				new NavegacaoTelas(painelLogin).novaJanela(Tela.HOMEPAGE_VIEW, "Homepage");
				new ArquivoLogin().registrarLogin(true);
			} catch (IOException | NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar tela");
			}
    	}else {
    		JOptionPane.showMessageDialog(null, "Login incorreto");
    	}
    	
    	
  
    }
    
    
    

}
