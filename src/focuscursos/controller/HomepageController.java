package focuscursos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import focuscursos.controller.constantes.Tela;
import focuscursos.controller.navegacao.NavegacaoTelas;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Instrutor;
import focuscursos.servicos.CursoServico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private ListView<?> listaCursosAdquiridos;

	@FXML
	private BorderPane painelPrincipal;

	private CursoServico servico = new CursoServico();

	@FXML
	void abrirPaginaLogin(ActionEvent event) {

	}

	@FXML
	void abrirApresentacoCurso(ActionEvent event) {
		abrirTelaApresentacao((Button) event.getSource());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// lista teste
		List<Curso> cursosTeste = new ArrayList<>();
		cursosTeste.add(new Curso("Java - Orientação a objeto",
				"Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation.[3] Diferente das linguagens de programação modernas, que são compiladas para código nativo, Java é compilada para um bytecode que é interpretado por uma máquina virtual (Java Virtual Machine, abreviada JVM). A linguagem de programação Java é a linguagem convencional da Plataforma Java, mas não é a sua única linguagem. A J2ME é utilizada em jogos de computador, celular, calculadoras, ou até mesmo o rádio do carro.",
				"/focuscursos/view/capacurso/Img1.jpg", new Instrutor("Joaquin", null, null, null, null, null)));
		cursosTeste.add(new Curso("Python - orientacao", "dasdsccxzcxc   xzczxa ",
				"/focuscursos/view/capacurso/Img2.jpg", new Instrutor()));
		cursosTeste.add(new Curso("C - orientacao a lista", "adsadsdasd ", "/focuscursos/view/capacurso/Img3.jpg",
				new Instrutor()));
		cursosTeste.add(
				new Curso("Javascript", "Linguagem de doido", "/focuscursos/view/capacurso/Img4.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Cobol", "Ddjjiajljekd ", "/focuscursos/view/capacurso/Img5.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Ruby - Curso completo", "Que nada rapa", "/focuscursos/view/capacurso/Img6.jpg",
				new Instrutor()));
		cursosTeste.add(
				new Curso("Javascript", "Linguagem de doido", "/focuscursos/view/capacurso/Img4.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Cobol", "Ddjjiajljekd ", "/focuscursos/view/capacurso/Img5.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Ruby - Curso completo", "Que nada rapa", "/focuscursos/view/capacurso/Img6.jpg",
				new Instrutor()));
		cursosTeste.add(
				new Curso("Javascript", "Linguagem de doido", "/focuscursos/view/capacurso/Img4.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Cobol", "Ddjjiajljekd ", "/focuscursos/view/capacurso/Img5.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Ruby - Curso completo", "Que nada rapa", "/focuscursos/view/capacurso/Img6.jpg",
				new Instrutor()));
		cursosTeste.add(
				new Curso("Javascript", "Linguagem de doido", "/focuscursos/view/capacurso/Img4.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Cobol", "Ddjjiajljekd ", "/focuscursos/view/capacurso/Img5.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Ruby - Curso completo", "Que nada rapa", "/focuscursos/view/capacurso/Img6.jpg",
				new Instrutor()));
		cursosTeste.add(
				new Curso("Javascript", "Linguagem de doido", "/focuscursos/view/capacurso/Img4.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Cobol", "Ddjjiajljekd ", "/focuscursos/view/capacurso/Img5.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Ruby - Curso completo", "Que nada rapa", "/focuscursos/view/capacurso/Img6.jpg",
				new Instrutor()));

		Button gridBotoes[] = { btnCurso1, btnCurso2, btnCurso3, btnCurso4, btnCurso5, btnCurso6, btnCurso7, btnCurso8,
				btnCurso9, btnCurso10, btnCurso11, btnCurso12 };

		for (int i = 0; i < cursosTeste.size(); i++) {
			try {
				gridBotoes[i].setUserData(cursosTeste.get(i));
				preencherBotaoCurso(gridBotoes[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				cursosTeste.remove(i);
			}
		}

		// TODO Setar os botões la no fxml para visible = false

	}

	private void preencherBotaoCurso(Button btn) {
		Curso userDataCurso = (Curso) btn.getUserData();
		((ImageView) btn.getGraphic()).setImage(new Image(userDataCurso.getUrlImagem()));
		btn.setText(userDataCurso.getTitulo());
	}

	private void abrirTelaApresentacao(Button btn) {
		Curso cursoSelecionado = (Curso) btn.getUserData();

		try {
			new NavegacaoTelas(painelPrincipal).mudarTela(Tela.APRESENTACAO_CURSO, cursoSelecionado.getTitulo(), cursoSelecionado);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}
	}

}
