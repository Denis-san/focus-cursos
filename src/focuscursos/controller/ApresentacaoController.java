package focuscursos.controller;

import java.net.URL;
import java.util.ResourceBundle;

import focuscursos.model.entidade.Curso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class ApresentacaoController implements Initializable {

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
	private ListView<?> listaCursosAdquiridos;

	@FXML
	private BorderPane borderSecundario;

	private Curso curso;

	@FXML
	void realizarInscricao(ActionEvent event) {
		System.out.println("inscrição: " + curso.getTitulo());
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
	}

}
