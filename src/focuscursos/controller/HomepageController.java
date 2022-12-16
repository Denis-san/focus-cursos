package focuscursos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import focuscursos.controller.constantes.Tela;
import focuscursos.controller.navegacao.NavegacaoTelas;
import focuscursos.model.entidade.Aluno;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Instrutor;
import focuscursos.model.entidade.Usuario;
import focuscursos.servicos.CursoServico;
import focuscursos.servicos.LoginServico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class HomepageController implements Initializable {

	@FXML
	private Button btnBuscar;

	@FXML
	private Button btnCurso1;

	@FXML
	private Button btnCurso10;

	@FXML
	private Button btnCurso11;

	@FXML
	private Button btnCurso12;

	@FXML
	private Button btnCurso2;

	@FXML
	private Button btnCurso3;

	@FXML
	private Button btnCurso4;

	@FXML
	private Button btnCurso5;

	@FXML
	private Button btnCurso6;

	@FXML
	private Button btnCurso7;

	@FXML
	private Button btnCurso8;

	@FXML
	private Button btnCurso9;

	@FXML
	private Button btnHomepage;

	@FXML
	private MenuButton btnLogin;

	@FXML
	private TextField inputPesquisar;

	@FXML
	private ListView<Curso> listaView;

	@FXML
	private BorderPane painelPrincipal;

	@FXML
	private BorderPane borderSecundario;

	@FXML
	private MenuItem btnModoAluno;

	@FXML
	private Label rotuloLista;

	private LoginServico loginServico = new LoginServico();

	private boolean modoAlunoAtivo = false;

	private CursoServico cursoServico = new CursoServico();

	@FXML
	void irParaCurso(MouseEvent event) {
		try {
			Curso cursoSelecionado = listaView.getSelectionModel().getSelectedItem();

			if (cursoSelecionado != null) {
				new NavegacaoTelas(painelPrincipal).mudarParaTelaAula(cursoSelecionado);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}
	}

	@FXML
	void abrirApresentacoCurso(ActionEvent event) {
		abrirTelaApresentacao((Button) event.getSource());
	}

	@FXML
	void abrirTelaHomepage(ActionEvent event) {
		try {
			new NavegacaoTelas(painelPrincipal).retornarParaHomePage();
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}
	}

	@FXML
	void deslogar(ActionEvent event) {

		try {
			loginServico.fazerLogoff();

			new NavegacaoTelas(painelPrincipal).retornarParaTelaInicial();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());

		}

	}

	@FXML
	void irPerfil(ActionEvent event) {

		try {
			Usuario usuario = loginServico.obterUsuarioLogado();
			new NavegacaoTelas(borderSecundario).mudarTela(Tela.PERFIL_VIEW, "Meu perfil", usuario);
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}

	}

	@FXML
	void mudarModoAlunoInstrutor(ActionEvent event) {
		ObservableList<Curso> observableArrayList = null;
		Usuario usuario;

		try {

			usuario = loginServico.obterUsuarioLogado();

			if (usuario instanceof Instrutor) {
				if (modoAlunoAtivo == false) {
					observableArrayList = FXCollections.observableArrayList(usuario.getCursosAdquiridos());
					modoAlunoAtivo = true;
					rotuloLista.setText("Meus cursos");
					btnModoAluno.setText("modo instrutor");
				} else {
					observableArrayList = FXCollections.observableArrayList(usuario.getCursos());
					modoAlunoAtivo = false;
					rotuloLista.setText("Meus cursos (Instrutor)");
					btnModoAluno.setText("modo Aluno");
				}

			}

		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}

		listaView.setItems(observableArrayList);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		List<Curso> cursosCadastrados = null;

		try {
			cursosCadastrados = cursoServico.todosOsCursos();
		} catch (ClassNotFoundException | IOException e1) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e1.getMessage());
		}

		Button gridBotoes[] = { btnCurso1, btnCurso2, btnCurso3, btnCurso4, btnCurso5, btnCurso6, btnCurso7, btnCurso8,
				btnCurso9, btnCurso10, btnCurso11, btnCurso12 };

		for (int i = 0; i < cursosCadastrados.size(); i++) {
			try {
				gridBotoes[i].setUserData(cursosCadastrados.get(i));
				preencherBotaoCurso(gridBotoes[i]);
				gridBotoes[i].setVisible(true);
			} catch (ArrayIndexOutOfBoundsException e) {
				gridBotoes[i].setVisible(false);
				cursosCadastrados.remove(i);
			}
		}

		try {
			Usuario usuario = loginServico.obterUsuarioLogado();

			ObservableList<Curso> observableArrayList = FXCollections.observableArrayList(usuario.getCursos());
			listaView.setItems(observableArrayList);

			if (usuario instanceof Aluno) {
				rotuloLista.setText("Meus cursos");
				btnModoAluno.setVisible(false);
			} else {
				rotuloLista.setText("Meus cursos (Instrutor)");
			}

		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}

	}

	private void preencherBotaoCurso(Button btn) {
		Curso userDataCurso = (Curso) btn.getUserData();
		((ImageView) btn.getGraphic()).setImage(new Image(userDataCurso.getUrlImagem()));
		btn.setText(userDataCurso.getTitulo());
	}

	private void abrirTelaApresentacao(Button btn) {
		Curso cursoSelecionado = (Curso) btn.getUserData();
		try {
			new NavegacaoTelas(borderSecundario).mudarTela(Tela.APRESENTACAO_CURSO, cursoSelecionado.getTitulo(),
					cursoSelecionado);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}
	}

}
