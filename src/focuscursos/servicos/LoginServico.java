package focuscursos.servicos;

import java.io.IOException;
import java.util.List;

import focuscursos.model.entidade.Usuario;
import focuscursos.model.persistencia.ArquivoLogin;
import focuscursos.model.persistencia.GenericArquivo;

public class LoginServico {

	private static final String CAMINHO_ARQUIVO = "arquivos/arquivoCadastro.fc";
	private GenericArquivo<Usuario> persistencia = new GenericArquivo<>();
	private ArquivoLogin arquivoLogin = new ArquivoLogin();

	public Usuario fazerLogin(String email, String senha) throws ClassNotFoundException, IOException {

		List<Usuario> cadastros = persistencia.obterElementosCadastrados(CAMINHO_ARQUIVO);

		if (cadastros == null) {
			return null;
		}

		for (Usuario usuario : cadastros) {

			if (usuario.getEmail().equals(email)) {

				if (usuario.getSenha().equals(senha)) {
					return usuario;
				}
			}
		}

		return null;
	}

	public void fazerLogoff() throws IOException {
		arquivoLogin.apagarDadosConta();
	}

	public Usuario obterUsuarioLogado() throws ClassNotFoundException, IOException {
		return arquivoLogin.obterUsuarioLogado();
	}

	public void registrarLoginNoArquivo(Usuario usuario) throws IOException {
		arquivoLogin.registrarLogin(usuario);

	}
}
