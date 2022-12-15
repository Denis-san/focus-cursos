package focuscursos.servicos;

import java.io.IOException;

import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Usuario;
import focuscursos.model.persistencia.ArquivoLogin;
import focuscursos.model.persistencia.GenericArquivo;
import focuscursos.model.persistencia.exception.UsuarioNaoEncontradoException;

public class CadastroServico {



	private static final String CAMINHO_ARQUIVO = "arquivos/arquivoCadastro.fc";
	private GenericArquivo<Usuario> persistencia = new GenericArquivo<>();
	private ArquivoLogin arquivoLogin = new ArquivoLogin();

	public void cadastrarUsuario(Usuario usuario) throws ClassNotFoundException, IOException {
		persistencia.cadastrar(usuario, CAMINHO_ARQUIVO);
	}

	public void inscreverUsuarioCurso(Usuario usuario, Curso curso)
			throws ClassNotFoundException, IOException, UsuarioNaoEncontradoException {

		Usuario usuarioAtualizar = usuario;
		usuarioAtualizar.getCursoAdquiridos().add(curso);

		persistencia.atualizarElemento(usuario, usuarioAtualizar, CAMINHO_ARQUIVO);
		
		arquivoLogin.registrarLogin(usuarioAtualizar);
	}
	
	
	public void atualizarCadastro(Usuario usuario, Usuario oldUsuario) throws ClassNotFoundException, IOException, UsuarioNaoEncontradoException {
		persistencia.atualizarElemento(oldUsuario, usuario, CAMINHO_ARQUIVO);
	}

}
