package focuscursos.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import focuscursos.controller.constantes.Tela;
import focuscursos.controller.navegacao.NavegacaoTelas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class TelaInicialController {

	@FXML
	private BorderPane borderPanePrincipal;

	@FXML
	private Button btnCadastrar;

	@FXML
	private Button btnEntrar;

	@FXML
	void abrirPaginaCadastro(ActionEvent event) {
		abrirTela(Tela.CADASTRO_VIEW);
	}

	@FXML
	void abrirPaginaLogin(ActionEvent event) {
		abrirTela(Tela.LOGIN_VIEW);
	}

	@FXML
	void abrirTelaInicial(ActionEvent event) {
		try {
			new NavegacaoTelas(borderPanePrincipal).retornarParaTelaInicial();
		} catch (IOException | NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Erro!:\n" + e.getMessage(), "Algo não deu certo!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void abrirTela(String tela) {
		try {
			new NavegacaoTelas(borderPanePrincipal).mudarTela(tela);
		} catch (IOException | NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Erro!:\n" + e.getLocalizedMessage(), "Algo não deu certo!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
