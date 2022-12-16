package focuscursos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import focuscursos.controller.constantes.Tela;
import focuscursos.controller.navegacao.NavegacaoTelas;
import focuscursos.model.entidade.Aluno;
import focuscursos.model.entidade.Aula;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Instrutor;
import focuscursos.model.entidade.MaterialDeApoio;
import focuscursos.model.entidade.Usuario;
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

		// lista teste
		List<Curso> cursosTeste = new ArrayList<>();
		Curso c1 = new Curso("Java - Orientação a objeto",
				"Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation.[3] Diferente das linguagens de programação modernas, que são compiladas para código nativo, Java é compilada para um bytecode que é interpretado por uma máquina virtual (Java Virtual Machine, abreviada JVM). A linguagem de programação Java é a linguagem convencional da Plataforma Java, mas não é a sua única linguagem. A J2ME é utilizada em jogos de computador, celular, calculadoras, ou até mesmo o rádio do carro.",
				"/focuscursos/view/capacurso/Img1.jpg", new Instrutor("Joaquin", null, null, null, null, null));
		c1.getAulas().add(new Aula("Aula 1 - Testando os bglh", "https://www.youtube.com/embed/5YKNSZ7mE_A?autoplay=1", null, new MaterialDeApoio("google", "https://google.com")));
		cursosTeste.add(c1);
		c1.getAulas().add(new Aula("Aula 2 - Testando d", "https://www.youtube.com/embed/BIM_sbigj_Q?autoplay=1", null, new MaterialDeApoio("doc oracle", "https://docs.oracle.com/javase/8/javafx/embedded-browser-tutorial/js-javafx.htm")));
		c1.getAulas().add(new Aula("Aula 3 - Testando ", "https://www.youtube.com/embed/5YKNSZ7mE_A?autoplay=1", null, new MaterialDeApoio("github", "https://github.com")));
		c1.getAulas().add(new Aula("Aula 3 - Testando ", "https://www.youtube.com/embed/BdJbe-SYRxU?autoplay=1", null, new MaterialDeApoio("facebook", "https://facebook.com")));
		c1.getAulas().add(new Aula("Aula 3 - Testando ", "https://www.youtube.com/embed/vpqtB5rniAc?autoplay=1", null, new MaterialDeApoio("drive", "https://drive.google.com")));
		
		Curso c2 = new Curso("Java - Orientação a objeto",
				"Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation.[3] Diferente das linguagens de programação modernas, que são compiladas para código nativo, Java é compilada para um bytecode que é interpretado por uma máquina virtual (Java Virtual Machine, abreviada JVM). A linguagem de programação Java é a linguagem convencional da Plataforma Java, mas não é a sua única linguagem. A J2ME é utilizada em jogos de computador, celular, calculadoras, ou até mesmo o rádio do carro.",
				"/focuscursos/view/capacurso/Img1.jpg", new Instrutor("Joaquin", null, null, null, null, null));
		
		cursosTeste.add(c2);
		
		Curso c3 = new Curso("Java - Orientação a objeto",
				"Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation.[3] Diferente das linguagens de programação modernas, que são compiladas para código nativo, Java é compilada para um bytecode que é interpretado por uma máquina virtual (Java Virtual Machine, abreviada JVM). A linguagem de programação Java é a linguagem convencional da Plataforma Java, mas não é a sua única linguagem. A J2ME é utilizada em jogos de computador, celular, calculadoras, ou até mesmo o rádio do carro.",
				"/focuscursos/view/capacurso/Img1.jpg", new Instrutor("Joaquin", null, null, null, null, null));
		
		cursosTeste.add(c3);

		cursosTeste.add(new Curso("Educação financeira", "dasdsccxzcxc   xzczxa ",
				"/focuscursos/view/capacurso/Img2.jpg", new Instrutor()));

		cursosTeste.add(new Curso("Analista de finanças", "adsadsdasd ", "/focuscursos/view/capacurso/Img3.jpg",
				new Instrutor()));

		cursosTeste.add(new Curso("Produtividade em equipe", "Linguagem de doido",
				"/focuscursos/view/capacurso/Img4.jpg", new Instrutor()));

		cursosTeste.add(
				new Curso("Python do zero", "Ddjjiajljekd ", "/focuscursos/view/capacurso/Img5.jpg", new Instrutor()));

		cursosTeste.add(new Curso("Guia da carreira", "Que nada rapa", "/focuscursos/view/capacurso/Img6.jpg",
				new Instrutor()));

		cursosTeste.add(new Curso("Administração de empresas", "Linguagem de doido",
				"/focuscursos/view/capacurso/Img7.jpg", new Instrutor()));

		cursosTeste.add(new Curso("Técnicas de estudos", "Ddjjiajljekd ", "/focuscursos/view/capacurso/Img8.jpg",
				new Instrutor()));

		cursosTeste.add(new Curso("Técnicas de leitura", "Que nada rapa", "/focuscursos/view/capacurso/Img9.jpg",
				new Instrutor()));
		cursosTeste.add(new Curso("Álgebra Linear", "Linguagem de doido", "/focuscursos/view/capacurso/Img10.jpg",
				new Instrutor()));

		Button gridBotoes[] = { btnCurso1, btnCurso2, btnCurso3, btnCurso4, btnCurso5, btnCurso6, btnCurso7, btnCurso8,
				btnCurso9, btnCurso10, btnCurso11, btnCurso12 };

		for (int i = 0; i < cursosTeste.size(); i++) {
			try {
				gridBotoes[i].setUserData(cursosTeste.get(i));
				preencherBotaoCurso(gridBotoes[i]);
				gridBotoes[i].setVisible(true);
			} catch (ArrayIndexOutOfBoundsException e) {
				gridBotoes[i].setVisible(false);
				cursosTeste.remove(i);
			}
		}

		// TODO Setar os botões la no fxml para visible = false

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
