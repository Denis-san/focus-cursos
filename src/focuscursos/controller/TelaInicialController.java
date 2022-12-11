package focuscursos.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import focuscursos.controller.navegacao.NavegacaoTelas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class TelaInicialController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnEntrar;

    @FXML
    private BorderPane painelPrincipal;

    @FXML
    void abrirPaginaCadastro(ActionEvent event) {
    	
    	try {
			new NavegacaoTelas(painelPrincipal).mudarTela("/focuscursos/view/cadastro-view.fxml");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
    	
    }

    @FXML
    void abrirPaginaLogin(ActionEvent event) {
    	try {
			new NavegacaoTelas(painelPrincipal).mudarTela("/focuscursos/view/login-view.fxml");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
    }
    
    @FXML
    void abrirPaginaInicial(ActionEvent event) {
    	try {
			new NavegacaoTelas(painelPrincipal).retornarParaTelaInicial();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
    }

}
