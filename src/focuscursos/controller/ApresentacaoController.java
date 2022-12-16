package focuscursos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class ApresentacaoController implements Initializable {

	@FXML
	private Button btnIncrever;

	@FXML
	private ImageView imagemThumbnailCurso;

	@FXML
	private Label labelDescricao;

	@FXML
	private Label labelNomeInstrutor;

	@FXML
	private Label labelTituloCurso;

	@FXML
	private BorderPane borderSecundario;

	private Curso curso;

	private LoginServico loginServico = new LoginServico();

	private CadastroServico cadastroUsuarioServico = new CadastroServico();

	private Usuario usuario;

	@FXML
	void realizarInscricao(ActionEvent event) {
		try {
			if (usuario.getCursos().contains(curso) == false) {
				cadastroUsuarioServico.inscreverUsuarioCurso(usuario, curso);
			}
			new NavegacaoTelas(borderSecundario).mudarParaTelaAula(curso);
		} catch (ClassNotFoundException | IOException | UsuarioNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void carregarCurso(Curso cursoSelecionado) {

		this.curso = cursoSelecionado;

		labelTituloCurso.setText(cursoSelecionado.getTitulo());
		imagemThumbnailCurso.setImage(new Image(curso.getUrlImagem()));
		labelDescricao.setText(curso.getDescricao());
		labelNomeInstrutor.setText("Instrutor: " + curso.getInstrutor().getNome());

		try {
			usuario = loginServico.obterUsuarioLogado();

			if (usuario.getCursos().contains(cursoSelecionado)) {
				btnIncrever.setStyle("-fx-background-color: white; -fx-border-color: #587d9f; -fx-text-fill: #587d9f;");

				if (usuario instanceof Instrutor) {
					btnIncrever.setText("Você é o instrutor desse curso!");
					btnIncrever.setDisable(true);
				} else {
					btnIncrever.setText("Assistir aulas");
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}
	}

}
