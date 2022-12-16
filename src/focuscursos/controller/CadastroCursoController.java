package focuscursos.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import focuscursos.controller.constantes.Tela;
import focuscursos.controller.navegacao.NavegacaoTelas;
import focuscursos.model.entidade.Aula;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Instrutor;
import focuscursos.model.entidade.MaterialDeApoio;
import focuscursos.model.persistencia.exception.UsuarioNaoEncontradoException;
import focuscursos.servicos.CadastroServico;
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
	private Button btnAtualizar;

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
	
	private LoginServico loginServico = new LoginServico();

	@FXML
	void adicionarAula(ActionEvent event) {

		Aula aula = instanciarAulaCampos();
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
			// obtendo o usuario logado
			Instrutor oldInstrutor = (Instrutor) new LoginServico().obterUsuarioLogado();
			Instrutor instrutor = (Instrutor) new LoginServico().obterUsuarioLogado();
			
			// efetuando a relação instrutor curso
			curso.setInstrutor(instrutor);
			instrutor.getCursoCadastrados().add(curso);

			// efetuando o cadastro do curso
			cursoServico.cadastrarCurso(curso);
			JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
			
			// guardando as novas alterações
			loginServico.registrarLoginNoArquivo(instrutor);
			new CadastroServico().atualizarCadastro(oldInstrutor, instrutor);
			
			// redirecionando para tela inicial
			new NavegacaoTelas(borderPrincipal).novaJanela(Tela.HOMEPAGE_VIEW, "homepage");
			
		} catch (ClassNotFoundException | IOException | UsuarioNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, "Erro! \n" + e.getMessage());
		}
	}

	@FXML
	void editarAula(ActionEvent event) {
		Aula aulaSelecionada = listaAulaAdicionadas.getSelectionModel().getSelectedItem();

		inputTituloAula.setText(aulaSelecionada.getTitulo());
		inputLinkAula.setText(aulaSelecionada.getLinkVideo());
		inputMaterialApoio.setText(aulaSelecionada.getMaterialDeApoio().getNome());
		inputLinkArquivo.setText(aulaSelecionada.getMaterialDeApoio().getLink());

		btnAdicionarAula.setDisable(true);
		btnAtualizar.setDisable(false);

	}

	@FXML
	void atualizarAula(ActionEvent event) {

		if (btnAdicionarAula.isDisable()) {
			Aula aulaSelecionada = instanciarAulaCampos();
			int indexSelecionado = listaAulaAdicionadas.getSelectionModel().getSelectedIndex();

			ObservableList<Aula> observableArrayListAulas = FXCollections.observableArrayList(aulasAdicionadas);
			observableArrayListAulas.set(indexSelecionado, aulaSelecionada);

			listaAulaAdicionadas.setItems(observableArrayListAulas);

			aulasAdicionadas.set(indexSelecionado, aulaSelecionada);

			limparCamposAula();

			btnAdicionarAula.setDisable(false);
			btnAtualizar.setDisable(true);
		}

	}

	@FXML
	void removerAula(ActionEvent event) {

		Aula aulaSelecionada = listaAulaAdicionadas.getSelectionModel().getSelectedItem();
		if (aulaSelecionada != null) {
			ObservableList<Aula> observableArrayListAulas = FXCollections.observableArrayList(aulasAdicionadas);
			observableArrayListAulas.remove(aulaSelecionada);

			listaAulaAdicionadas.setItems(observableArrayListAulas);

			aulasAdicionadas.remove(aulaSelecionada);

		}

	}

	private void limparCamposAula() {
		inputTituloAula.setText("");
		inputLinkAula.setText("");
		inputMaterialApoio.setText("");
		inputLinkArquivo.setText("");
	}

	private Aula instanciarAulaCampos() {
		Aula aula = new Aula();
		aula.setTitulo(inputTituloAula.getText());
		aula.setLinkVideo(inputLinkAula.getText());

		MaterialDeApoio matApoio = new MaterialDeApoio();
		matApoio.setNome(inputMaterialApoio.getText());
		matApoio.setLink(inputLinkArquivo.getText());
		aula.setMaterialDeApoio(matApoio);

		return aula;
	}

}
