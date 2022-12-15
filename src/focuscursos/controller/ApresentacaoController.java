package focuscursos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import focuscursos.controller.constantes.Tela;
import focuscursos.controller.navegacao.NavegacaoTelas;
import focuscursos.model.entidade.Aluno;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Usuario;
import focuscursos.model.persistencia.exception.UsuarioNaoEncontradoException;
import focuscursos.servicos.CadastroServico;
import focuscursos.servicos.LoginServico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class ApresentacaoController implements Initializable{

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
	private ListView<Curso> listaCursosAdquiridos;

	@FXML
	private BorderPane borderSecundario;

	@FXML
	private Label rotuloLista;

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
			new NavegacaoTelas(borderSecundario).novaJanela(Tela.AULA_VIEW, curso.getAulas().get(0).getTitulo());
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
				btnIncrever.setText("Assistir aulas");
			}

			ObservableList<Curso> observableArrayList = FXCollections.observableArrayList(usuario.getCursos());
			listaCursosAdquiridos.setItems(observableArrayList);

			if (usuario instanceof Aluno) {
				rotuloLista.setText("Meus cursos");
			} else {
				rotuloLista.setText("Meus cursos (Instrutor)");
			}
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}
	}

	

}
