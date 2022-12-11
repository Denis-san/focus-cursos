package focuscursos;

import java.net.URL;
import focuscursos.controller.constantes.Tela;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Aplicacao extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		URL fxmlFilePath = getClass().getResource(Tela.TELA_INICIAL);

		Parent fxmlParent = (Parent) FXMLLoader.load(fxmlFilePath);
		stage.setScene(new Scene(fxmlParent, 1209, 620));
		stage.setTitle("Focus Cursos");
		stage.getIcons().add(new Image("/focuscursos/view/icones/logo-favicon.png"));
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
