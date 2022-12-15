package focuscursos.controller;

import focuscursos.model.entidade.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class PerfilController {

    @FXML
    private Button btnAtualizarCadastro;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnBuscar1;

    @FXML
    private BorderPane btnHomepage;

    @FXML
    private ImageView btnLogin;

    @FXML
    private Button btnTornarInstrutor;

    @FXML
    private TextField inputCpf;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputNome;

    @FXML
    private TextField inputPesquisar;

    @FXML
    private PasswordField inputSenha;

    @FXML
    private TextField inputSobrenome;

    @FXML
    private TextField inputTelefone;

    @FXML
    private ListView<?> listaCursosAdquiridos;

    @FXML
    void atualizarCadastro(ActionEvent event) {
    	
    }

    @FXML
    void tornarInstrutor(ActionEvent event) {

    }
    
    public void carregarDados(Usuario usuario) {
    	inputNome.setText(usuario.getNome());
    	inputSobrenome.setText(usuario.getSobrenome());
    	inputEmail.setText(usuario.getEmail());
    	inputCpf.setText(usuario.getCpf());
    	inputSenha.setText(usuario.getSenha());
    	inputTelefone.setText(usuario.getTelefone());
    	
    }

}
