package focuscursos.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import focuscursos.controller.constantes.Tela;
import focuscursos.controller.navegacao.NavegacaoTelas;
import focuscursos.model.entidade.Aula;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.MaterialDeApoio;
import focuscursos.servicos.AulaServico;
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

	private int indiceVideoAtual = 0;

	private AulaServico aulaServico = new AulaServico();

	private Aula aulaAtual;

	@FXML
	void acessarMateriaisDisponibilizados(MouseEvent event) {
		MaterialDeApoio matApoio = aulaAtual.getMaterialDeApoio();

		if (matApoio != null) {
			try {
				Desktop.getDesktop().browse(new URL(matApoio.getLink()).toURI());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@FXML
	void avancarAula(ActionEvent event) {
		Aula aulaSelecionada = null;
		try {
			aulaSelecionada = curso.getAulas().get(++indiceVideoAtual);
		} catch (IndexOutOfBoundsException err) {
			btnProximaAula.setDisable(true);
		}

		aulaAtual = aulaSelecionada;

		if (aulaAtual != null) {
			listaMateriaisDisponibilizados
					.setItems(FXCollections.observableArrayList(Arrays.asList(aulaAtual.getMaterialDeApoio())));
			labelTituloAula.setText(aulaAtual.getTitulo());
			textAreaAnotacoes.setText(aulaAtual.getAnotacoes());
		}

		if (aulaSelecionada != null) {
			labelLoading.setVisible(true);

			URL url = getClass().getResource("/focuscursos/view/util/index.html");
			webViewVideo.getEngine().load(url.toString());

			webViewVideo.getEngine().load(aulaSelecionada.getLinkVideo());

			webViewVideo.getEngine().getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
				if (newState == webViewVideo.getEngine().getLoadWorker().getState().SUCCEEDED) {
					labelLoading.setVisible(false);
				}
			});

		}

	}

	@FXML
	void cancelarAnotacao(ActionEvent event) {
		textAreaAnotacoes.setText("");
	}

	@FXML
	void salvarAnotacao(ActionEvent event) {
		try {
			Aula aula = curso.getAulas().get(indiceVideoAtual);
			aula.setAnotacoes(textAreaAnotacoes.getText());
			aulaServico.gravarAnotacao(aula);
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@FXML
	void voltarAula(ActionEvent event) {
		Aula aulaSelecionada = null;
		try {
			aulaSelecionada = curso.getAulas().get(--indiceVideoAtual);
		} catch (IndexOutOfBoundsException err) {
			btnAulaAnterior.setDisable(true);
		}

		aulaAtual = aulaSelecionada;
		textAreaAnotacoes.setText(aulaSelecionada.getAnotacoes());
		listaMateriaisDisponibilizados
				.setItems(FXCollections.observableArrayList(Arrays.asList(aulaAtual.getMaterialDeApoio())));

		labelTituloAula.setText(aulaAtual.getTitulo());

		if (aulaSelecionada != null) {
			labelLoading.setVisible(true);

			URL url = getClass().getResource("/focuscursos/view/util/index.html");
			webViewVideo.getEngine().load(url.toString());

			webViewVideo.getEngine().load(aulaSelecionada.getLinkVideo());

			webViewVideo.getEngine().getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
				if (newState == webViewVideo.getEngine().getLoadWorker().getState().SUCCEEDED) {
					labelLoading.setVisible(false);
				}
			});

		}
	}

	@FXML
	void voltarParaHomePage(ActionEvent event) {
		try {
			URL url = getClass().getResource("/focuscursos/view/util/index.html");
			webViewVideo.getEngine().load(url.toString());
			new NavegacaoTelas(borderpPrincipal).novaJanela(Tela.HOMEPAGE_VIEW, "Homepage");
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

			aulaAtual = aulaSelecionada;
			indiceVideoAtual = listaAulas.getSelectionModel().getSelectedIndex();
			listaMateriaisDisponibilizados
					.setItems(FXCollections.observableArrayList(Arrays.asList(aulaAtual.getMaterialDeApoio())));

			labelTituloAula.setText(aulaAtual.getTitulo());

			textAreaAnotacoes.setText(aulaSelecionada.getAnotacoes());
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

		labelTituloAula.setText(curso.getAulas().get(0).getTitulo());
	}

}
