package focuscursos.controller.navegacao;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class NavegacaoTelas {
	private BorderPane painelPrincipal;
	
	public NavegacaoTelas(BorderPane painelPrincipal) {
		this.painelPrincipal = painelPrincipal;
	}
	
	public void mudarTela(String caminhoFxml) throws IOException{
		
		Parent raiz = FXMLLoader.load(getClass().getResource(caminhoFxml));
		
		if(painelPrincipal.getCenter() == null || painelPrincipal.getCenter().getParent().equals(raiz) == false){
			painelPrincipal.setCenter(raiz);
		}
		
	}
	
	public void retornarParaTelaInicial() throws IOException {
		Parent raiz = FXMLLoader.load(getClass().getResource("/focuscursos/view/tela-inicial-view.fxml"));
		
		painelPrincipal.getParent().getScene().setRoot(raiz);
	}
	
	
	
}
