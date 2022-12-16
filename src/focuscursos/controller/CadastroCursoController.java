package focuscursos.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import focuscursos.model.entidade.Aula;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Instrutor;
import focuscursos.model.entidade.MaterialDeApoio;
import focuscursos.servicos.CursoServico;
import focuscursos.servicos.LoginServico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CadastroCursoController {

	@FXML
	private Button btnAdicionarAula;

	@FXML
	private Button btnAnexarImagem;

	@FXML
	private Button btnCriarCurso;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnLimpar;

	@FXML
	private Button btnRemoverAula;

	@FXML
	private ImageView imageThumbnail;

	@FXML
	private TextArea inputDescricaoCurso;

	@FXML
	private TextField inputLinkArquivo;

	@FXML
	private TextField inputLinkAula;

	@FXML
	private TextField inputMaterialApoio;

	@FXML
	private TextField inputTituloAula;

	@FXML
	private TextField inputTituloCurso;

	@FXML
	private ListView<Aula> listaAulaAdicionadas;

	@FXML
	private BorderPane borderPrincipal;

	private List<Aula> aulasAdicionadas = new ArrayList<>();

	private String imageThumb;

	private CursoServico cursoServico = new CursoServico();
	
	

	@FXML
	void adicionarAula(ActionEvent event) {
		Aula aula = new Aula();
		aula.setTitulo(inputTituloAula.getText());
		aula.setLinkVideo(inputLinkAula.getText());

		MaterialDeApoio matApoio = new MaterialDeApoio();
		matApoio.setNome(inputMaterialApoio.getText());
		matApoio.setLink(inputLinkArquivo.getText());
		aula.setMaterialDeApoio(matApoio);

		aulasAdicionadas.add(aula);

		ObservableList<Aula> observableArrayListAulas = FXCollections.observableArrayList(aulasAdicionadas);
		listaAulaAdicionadas.setItems(observableArrayListAulas);

		limparCamposAula();
	}

	@FXML
	void anexarImagemDoCurso(ActionEvent event) {
		FileChooser fil_chooser = new FileChooser();
		File file = fil_chooser.showOpenDialog(((Stage) borderPrincipal.getScene().getWindow()));
		imageThumbnail.setImage(new Image(file.getAbsolutePath()));
		imageThumb = file.getAbsolutePath();
	}

	@FXML
	void criarCurso(ActionEvent event) {
		Curso curso = new Curso();

		curso.setTitulo(inputTituloCurso.getText());
		curso.setDescricao(inputDescricaoCurso.getText());
		curso.setUrlImagem(imageThumb);

		curso.getAulas().addAll(aulasAdicionadas);
		

		try {
			curso.setInstrutor((Instrutor) new LoginServico().obterUsuarioLogado());
			cursoServico.cadastrarCurso(curso);
			JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}
	}

	@FXML
	void editarAula(ActionEvent event) {

	}

	@FXML
	void limparCampos(ActionEvent event) {
		limparCamposAula();
	}

	@FXML
	void removerAula(ActionEvent event) {

	}

	private void limparCamposAula() {
		inputTituloAula.setText("");
		inputLinkAula.setText("");
		inputMaterialApoio.setText("");
		inputLinkArquivo.setText("");
	}

}
