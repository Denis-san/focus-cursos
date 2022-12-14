package focuscursos.servicos;

import java.io.IOException;

import focuscursos.model.entidade.Usuario;
import focuscursos.model.persistencia.GenericArquivo;

public class CadastroServico {

//	private ArquivoCadastro persistencia = new ArquivoCadastro();
	
	
	private static final String CAMINHO_ARQUIVO = "arquivos/arquivoCadastro.fc";
	GenericArquivo<Usuario> persistencia = new GenericArquivo<>();

	public void cadastrarUsuario(Usuario usuario) throws ClassNotFoundException, IOException {

		persistencia.cadastrar(usuario, CAMINHO_ARQUIVO);

	}

}
