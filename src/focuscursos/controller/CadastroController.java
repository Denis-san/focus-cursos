package focuscursos.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import focuscursos.controller.constantes.Tela;
import focuscursos.controller.navegacao.NavegacaoTelas;
import focuscursos.model.entidade.Usuario;
import focuscursos.servicos.CadastroServico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class CadastroController {

	@FXML
	private Button btnCadastrar;

	@FXML
	private BorderPane borderSecundario;

	@FXML
	private TextField inputCpf;

	@FXML
	private TextField inputEmail;

	@FXML
	private TextField inputNome;

	@FXML
	private PasswordField inputSenha;

	@FXML
	private TextField inputSobrenome;

	@FXML
	private TextField inputTelefone;

	@FXML
	private Label labelFacaLogin;

	private CadastroServico servico = new CadastroServico();

	@FXML
	void abrirTelaLogin(MouseEvent event) {
		try {
			new NavegacaoTelas(borderSecundario).novaJanela(Tela.LOGIN_VIEW, "Fazer login");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}

	}

	@FXML
	void realizarCadastro(ActionEvent event) {

		String nome = inputNome.getText();
		String sobrenome = inputSobrenome.getText();
		String email = inputEmail.getText();
		String senha = inputSenha.getText();
		String cpf = inputCpf.getText();
		String telefone = inputTelefone.getText();

		Usuario usuario = new Usuario(nome, email, senha, telefone, sobrenome, cpf);

		try {
			servico.cadastrarUsuario(usuario);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!\n Por favor faça seu login", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

			new NavegacaoTelas(borderSecundario).novaJanela(Tela.LOGIN_VIEW, "Fazer login");
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}

	}

}
