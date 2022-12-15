package focuscursos.controller.navegacao;

import java.io.IOException;

import focuscursos.controller.ApresentacaoController;
import focuscursos.controller.constantes.Tela;
import focuscursos.model.entidade.Curso;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class NavegacaoTelas {

	private BorderPane painelPrincipal;

	public NavegacaoTelas(BorderPane painelPrincipal) {
		this.painelPrincipal = painelPrincipal;
	}

	public void mudarTela(String caminhoFxml) throws IOException {

		Parent raiz = FXMLLoader.load(getClass().getResource(caminhoFxml));

		if (painelPrincipal.getCenter() == null || painelPrincipal.getCenter().getParent().equals(raiz) == false) {
			painelPrincipal.setCenter(raiz);
		}

	}

	public void novaJanela(String caminhoFxml, String title) throws IOException {
		Parent tela = FXMLLoader.load(getClass().getResource(caminhoFxml));
		Stage stage = new Stage();
		stage.setTitle(title);
		stage.setScene(new Scene(tela));
		stage.getIcons().add(new Image("/focuscursos/view/icones/logo-favicon.png"));
		((Stage) painelPrincipal.getScene().getWindow()).close();
		stage.show();
	}

	public void retornarParaTelaInicial() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(Tela.TELA_INICIAL));
		painelPrincipal.getScene().setRoot(root);
	}
	
	public void retornarParaHomePage() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(Tela.HOMEPAGE_VIEW));
		painelPrincipal.getScene().setRoot(root);
	}

	public void mudarTela(String caminhoFxml, String tituloJanela, Curso cursoSelecionado) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoFxml));
		Parent raiz = loader.load();

		ApresentacaoController controller = loader.getController();
		controller.carregarCurso(cursoSelecionado);
		
		((Stage) painelPrincipal.getScene().getWindow()).setTitle(tituloJanela);

		if (painelPrincipal.getCenter() == null || painelPrincipal.getCenter().getParent().equals(raiz) == false) {
			painelPrincipal.setCenter(raiz);
		}

	}

}
