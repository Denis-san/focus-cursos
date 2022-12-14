package focuscursos.servicos;

import java.io.IOException;

import focuscursos.model.entidade.Usuario;
import focuscursos.model.persistencia.ArquivoCadastro;

public class CadastroServico {

	private ArquivoCadastro persistencia = new ArquivoCadastro();

	public void cadastrarUsuario(Usuario usuario) throws ClassNotFoundException, IOException {

		persistencia.cadastrarUsuario(usuario);

	}
	
	

}
