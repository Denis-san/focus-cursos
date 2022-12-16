package focuscursos.servicos;

import java.io.IOException;

import focuscursos.model.entidade.Aluno;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Usuario;
import focuscursos.model.persistencia.ArquivoLogin;
import focuscursos.model.persistencia.GenericArquivo;
import focuscursos.model.persistencia.exception.UsuarioNaoEncontradoException;

public class CadastroServico {

	private static final String CAMINHO_ARQUIVO = "arquivos/arquivoCadastro.fc";
	private GenericArquivo<Usuario> persistencia = new GenericArquivo<>();
	private ArquivoLogin arquivoLogin = new ArquivoLogin();

	
	// utiliza nosso objeto de persistencia (generico) para realizar o cadastro passando como parametro
	// o usuario que desejamos cadastrar e o caminho do arquivo no qual ele deve salvar
	public void cadastrarUsuario(Usuario usuario) throws ClassNotFoundException, IOException {
		persistencia.cadastrar(usuario, CAMINHO_ARQUIVO);
	}

	
	// recebe como paremetro o usuario e o curso que ele deseja se inscrever 
	// adiciona esse curso na lista de cursos do usuario e atualiza seu cadastro
	public void inscreverUsuarioCurso(Usuario usuario, Curso curso)
			throws ClassNotFoundException, IOException, UsuarioNaoEncontradoException {

		Usuario usuarioAtualizar = usuario;
		usuarioAtualizar.getCursosAdquiridos().add(curso);

		persistencia.atualizarElemento(usuario, usuarioAtualizar, CAMINHO_ARQUIVO);
		
		arquivoLogin.registrarLogin(usuarioAtualizar);
	}
	
	
	// recebe o objeto antigo e o novo objeto, para que la na persistencia ele possa pegar o index na lista
	// e atualizar esse objeto
	public void atualizarCadastro(Usuario oldUsuario, Usuario usuarioAtualizado) throws ClassNotFoundException, IOException, UsuarioNaoEncontradoException {
		persistencia.atualizarElemento(oldUsuario, usuarioAtualizado, CAMINHO_ARQUIVO);
	}

}
