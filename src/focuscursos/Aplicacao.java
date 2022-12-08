package focuscursos;

import javafx.application.Application;
import javafx.stage.Stage;

public class Aplicacao extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello world Application");
	    primaryStage.setWidth(300);
	    primaryStage.setHeight(200);

	    primaryStage.show();
	}
	
	public static void main(String[] args) {
	    Application.launch(args);
	}
}
