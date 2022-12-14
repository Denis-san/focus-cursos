package focuscursos.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Instrutor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
	private ImageView btnHomepage;

	@FXML
	private Button btnLogin;

	@FXML
	private TextField inputPesquisar;

	@FXML
	private ListView<?> listaCursosAdquiridos;

	@FXML
	void abrirPaginaLogin(ActionEvent event) {

	}

	@FXML
	void abrirApresentacoCurso(ActionEvent event) {
		abrirApresentacoCurso(event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// lista teste
		List<Curso> cursosTeste = new ArrayList<>();
		cursosTeste.add(new Curso("Java - orientacao a objt", "Que nada ", "/focuscursos/view/capacurso/Img1.jpg",
				new Instrutor()));
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
				new Curso("Adm - muda nada", "Que nada ", "/focuscursos/view/capacurso/Img7.jpg", new Instrutor()));
		cursosTeste.add(new Curso("engenharia muda o que?", "dasdsccxzcxc   xzczxa ",
				"/focuscursos/view/capacurso/Img8.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Churrascaria orientada a calculo 4", "adsadsdasd ",
				"/focuscursos/view/capacurso/Img9.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Chesperito mostra como bater martelo", "Linguagem de doido",
				"/focuscursos/view/capacurso/Img10.jpg", new Instrutor()));
		cursosTeste.add(new Curso("Chaves ensina curso de pandeiro", "Ddjjiajljekd ",
				"/focuscursos/view/capacurso/Img5.jpg", new Instrutor()));
		cursosTeste.add(new Curso("O rei leão ensinando javascript - orientacao a objt", "Que nada ",
				"/focuscursos/view/capacurso/Img1.jpg", new Instrutor()));

		Button gridBotoes[] = { btnCurso1, btnCurso2, btnCurso3, btnCurso4, btnCurso5, btnCurso6, btnCurso7, btnCurso8,
				btnCurso9, btnCurso10, btnCurso11, btnCurso12 };

		for (int i = 0; i < gridBotoes.length; i++) {
			listar(gridBotoes[i], cursosTeste.get(i));
		}

	}

	private void listar(Button btn, Curso curso) {
		((ImageView) btn.getGraphic()).setImage(new Image(curso.getUrlImagem()));
		btn.setText(curso.getTitulo());
	}

	private void abrirTelaApresentacao(Button btn) {
		
	}

}
