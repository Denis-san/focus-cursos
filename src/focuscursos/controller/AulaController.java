package focuscursos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import focuscursos.controller.navegacao.NavegacaoTelas;
import focuscursos.model.entidade.Aula;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.MaterialDeApoio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

public class AulaController implements Initializable {

	@FXML
	private Button btnAcessarRecursos;

	@FXML
	private Button btnAulaAnterior;

	@FXML
	private Button btnCancelarAnotacao;

	@FXML
	private Button btnPlayVideo;

	@FXML
	private Button btnProximaAula;

	@FXML
	private Button btnSalvarAnotacao;

	@FXML
	private Label labelLoading;

	@FXML
	private Label labelTituloAula;

	@FXML
	private BorderPane borderpPrincipal;

	@FXML
	private ListView<Aula> listaAulas;

	@FXML
	private ListView<MaterialDeApoio> listaMateriaisDisponibilizados;

	@FXML
	private TextArea textAreaAnotacoes;

	@FXML
	private WebView webViewVideo;

	private Curso curso;

	@FXML
	void acessarMateriaisDisponibilizados(ActionEvent event) {

	}

	@FXML
	void avancarAula(ActionEvent event) {

	}

	@FXML
	void cancelarAnotacao(ActionEvent event) {

	}

	@FXML
	void playVideo(ActionEvent event) {

	}

	@FXML
	void salvarAnotacao(ActionEvent event) {

	}

	@FXML
	void voltarAula(ActionEvent event) {

	}

	@FXML
	void voltarParaHomePage(ActionEvent event) {
		try {
			new NavegacaoTelas(borderpPrincipal).retornarParaHomePage();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	@FXML
	void irParaAula(MouseEvent event) {
		Aula aulaSelecionada = listaAulas.getSelectionModel().getSelectedItem();


		if (aulaSelecionada != null) {
			labelLoading.setVisible(true);
			webViewVideo.getEngine().load(aulaSelecionada.getLinkVideo());

			webViewVideo.getEngine().getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
				if (newState == webViewVideo.getEngine().getLoadWorker().getState().SUCCEEDED) {
					labelLoading.setVisible(false);
				}
			});
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		URL url = getClass().getResource("/focuscursos/view/util/index.html");
		webViewVideo.getEngine().load(url.toString());
	}

	public void carregarCurso(Curso curso) {
		this.curso = curso;

		// carregando lista de materiais de apoio
		ObservableList<MaterialDeApoio> observableArrayList = FXCollections
				.observableArrayList(curso.getAulas().get(0).getMaterialDeApoio());
		listaMateriaisDisponibilizados.setItems(observableArrayList);

		// carregando as aulas
		ObservableList<Aula> observableArrayListAulas = FXCollections.observableArrayList(curso.getAulas());
		listaAulas.setItems(observableArrayListAulas);

	}

}
