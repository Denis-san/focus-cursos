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

	public void cadastrarUsuario(Usuario usuario) throws ClassNotFoundException, IOException {
		persistencia.cadastrar(usuario, CAMINHO_ARQUIVO);
	}

	public void inscreverUsuarioCurso(Usuario usuario, Curso curso)
			throws ClassNotFoundException, IOException, UsuarioNaoEncontradoException {

		Usuario usuarioAtualizar = usuario;
		usuarioAtualizar.getCursosAdquiridos().add(curso);

		persistencia.atualizarElemento(usuario, usuarioAtualizar, CAMINHO_ARQUIVO);
		
		arquivoLogin.registrarLogin(usuarioAtualizar);
	}
	
	
	public void atualizarCadastro(Usuario oldUsuario, Usuario usuarioAtualizado) throws ClassNotFoundException, IOException, UsuarioNaoEncontradoException {
		String istance = (oldUsuario instanceof Aluno) ? "Aluno" : "Instrutor";
		String istanceNew = (usuarioAtualizado instanceof Aluno) ? "Aluno" : "Instrutor";
		System.out.println("instancia old: " + istance);
		System.out.println("instancia new: " + istanceNew);
		
		persistencia.atualizarElemento(oldUsuario, usuarioAtualizado, CAMINHO_ARQUIVO);
	}

}
