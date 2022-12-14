package focuscursos.controller.navegacao;

import java.io.IOException;

import focuscursos.controller.constantes.Tela;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
		painelPrincipal.getScene().getWindow().hide();
		stage.show();
	}
	
	public void retornarParaTelaInicial() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(Tela.TELA_INICIAL));
		painelPrincipal.getScene().setRoot(root);
	}

}
