package focuscursos.servicos;

import java.io.IOException;
import java.util.List;

import focuscursos.model.entidade.Usuario;
import focuscursos.model.persistencia.ArquivoCadastro;

public class LoginServico {

	private ArquivoCadastro arquivoPersistencia = new ArquivoCadastro();

	public boolean fazerLogin(String email, String senha) throws ClassNotFoundException, IOException {

		List<Usuario> cadastros = arquivoPersistencia.obterUsuariosCadastrados();

		for (Usuario usuario : cadastros) {

			if (usuario.getEmail().equals(email)) {

				if (usuario.getSenha().equals(senha)) {
					return true;
				}
			}
		}

		return false;
	}
}
