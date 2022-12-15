package focuscursos.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;

public class AulaController implements Initializable{

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
	private ListView<?> listaAulas;

	@FXML
	private ListView<?> listaMateriaisDisponibilizados;

	@FXML
	private TextArea textAreaAnotacoes;

	@FXML
	private WebView webViewVideo;

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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		URL url = getClass().getResource("/focuscursos/view/util/index.html");
		webViewVideo.getEngine().load(url.toString());
	}

}
