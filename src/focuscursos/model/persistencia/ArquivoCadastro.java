package focuscursos.model.persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import focuscursos.model.entidade.Usuario;

public class ArquivoCadastro {
	
	private static final String CAMINHO_ARQUIVO = "arquivos/arquivoCadastro.fc";
	private List<Usuario> usuariosCadastrados;

	public void cadastrarUsuario(Usuario usuario) throws ClassNotFoundException, IOException {

		usuariosCadastrados = obterUsuariosCadastrados();

		if (usuariosCadastrados == null) {
			usuariosCadastrados = new ArrayList<Usuario>();
		}

		FileOutputStream fileOutput = new FileOutputStream(CAMINHO_ARQUIVO);
		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

		usuariosCadastrados.add(usuario);
		objectOutput.writeObject(usuariosCadastrados);

		objectOutput.close();
		fileOutput.close();

	}

	public List<Usuario> obterUsuariosCadastrados() throws IOException, ClassNotFoundException {

		FileInputStream fileInput = new FileInputStream(CAMINHO_ARQUIVO);

		List<Usuario> usuarios = null;

		try (ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
			usuarios = (List<Usuario>) objectInput.readObject();
		} catch (EOFException e) {
			usuarios = null;
		}

		fileInput.close();

		return usuarios;
	}

}
