package focuscursos.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import focuscursos.controller.constantes.Tela;
import focuscursos.controller.navegacao.NavegacaoTelas;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Instrutor;
import focuscursos.model.entidade.Usuario;
import focuscursos.model.persistencia.exception.UsuarioNaoEncontradoException;
import focuscursos.servicos.CadastroServico;
import focuscursos.servicos.LoginServico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class PerfilController {

	@FXML
	private Button btnAtualizarCadastro;

	@FXML
	private Button btnBuscar;

	@FXML
	private Button btnBuscar1;

	@FXML
	private BorderPane borderPrincipal;

	@FXML
	private ImageView btnLogin;

	@FXML
	private Button btnTornarInstrutor;

	@FXML
	private TextField inputCpf;

	@FXML
	private TextField inputEmail;

	@FXML
	private TextField inputNome;

	@FXML
	private TextField inputPesquisar;

	@FXML
	private PasswordField inputSenha;

	@FXML
	private TextField inputSobrenome;

	@FXML
	private TextField inputTelefone;

	@FXML
	private Button btnCadastrarCurso;

	@FXML
	private ListView<Curso> listaCursosAdquiridos;

	private Usuario oldUsuario;

	private CadastroServico cadastroServico = new CadastroServico();

	private LoginServico loginServico = new LoginServico();

	@FXML
	void atualizarCadastro(ActionEvent event) {

		Usuario usuarioAtualizado = oldUsuario;

		usuarioAtualizado.setNome(inputNome.getText());
		usuarioAtualizado.setSobrenome(inputSobrenome.getText());
		usuarioAtualizado.setEmail(inputEmail.getText());
		usuarioAtualizado.setSenha(inputSenha.getText());
		usuarioAtualizado.setTelefone(inputTelefone.getText());

		try {
			cadastroServico.atualizarCadastro(oldUsuario, usuarioAtualizado);
			JOptionPane.showMessageDialog(null, "Dados atualizados!");
		} catch (ClassNotFoundException | IOException | UsuarioNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	@FXML
	void abrirTelaCadastroVideo(ActionEvent event) {
		try {
			new NavegacaoTelas(borderPrincipal).mudarTela(Tela.CADASTRO_VIDEO_VIEW);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@FXML
	void tornarInstrutor(ActionEvent event) {

		try {

			Usuario usuario = instanciarInstrutorDe(oldUsuario);

			cadastroServico.atualizarCadastro(oldUsuario, usuario);

			JOptionPane.showMessageDialog(null, "Dados atualizados!\nPronto! Você agora é um instrutor!");
			btnTornarInstrutor.setVisible(false);
			btnCadastrarCurso.setDisable(false);

			JOptionPane.showMessageDialog(null,
					"Para efetivar o modo instrutor Você precisa realizar o\n login novamente no sistema!");

			loginServico.fazerLogoff();
			new NavegacaoTelas(borderPrincipal).novaJanela(Tela.LOGIN_VIEW, "Realize seu login");

		} catch (ClassNotFoundException | IOException | UsuarioNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	private Instrutor instanciarInstrutorDe(Usuario usuario) {
		Instrutor instrutor = new Instrutor();
		instrutor.setNome(usuario.getNome());
		instrutor.setSobrenome(usuario.getSobrenome());
		instrutor.setEmail(usuario.getEmail());
		instrutor.setCpf(usuario.getCpf());
		instrutor.setSenha(usuario.getSenha());
		instrutor.setTelefone(usuario.getTelefone());
		instrutor.getCursosAdquiridos().addAll(usuario.getCursos());

		return instrutor;
	}

	public void carregarDados(Usuario usuario) {

		inputNome.setText(usuario.getNome());
		inputSobrenome.setText(usuario.getSobrenome());
		inputEmail.setText(usuario.getEmail());
		inputCpf.setText(usuario.getCpf());
		inputSenha.setText(usuario.getSenha());
		inputTelefone.setText(usuario.getTelefone());

		this.oldUsuario = usuario;

		if (usuario instanceof Instrutor) {
			btnTornarInstrutor.setVisible(false);
			btnCadastrarCurso.setDisable(false);
		}
	}

}
