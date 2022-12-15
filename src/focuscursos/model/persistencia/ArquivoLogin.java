package focuscursos.model.persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import focuscursos.model.entidade.Usuario;

public class ArquivoLogin {

	public boolean verificarLogon() throws IOException, ClassNotFoundException {
		Usuario result = null;

		try {
			FileInputStream fileInput = new FileInputStream("arquivos/arquivoLogin.fc");

			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			result = (Usuario) objectInput.readObject();

			objectInput.close();
		} catch (StreamCorruptedException | FileNotFoundException | EOFException e) {
			registrarLogin(result);
			result = null;
		}

		if (result == null) {
			return false;
		} else {
			return true;
		}

	}

	public Usuario obterUsuarioLogado() throws IOException, ClassNotFoundException {
		FileInputStream fileInput = new FileInputStream("arquivos/arquivoLogin.fc");
		Usuario result = null;
		ObjectInputStream objectInput = new ObjectInputStream(fileInput);
		result = (Usuario) objectInput.readObject();

		objectInput.close();
		
		return result;
	}
	
	public void registrarLogin(Usuario usuario) throws IOException {

		FileOutputStream fileOutput = new FileOutputStream("arquivos/arquivoLogin.fc");

		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

		objectOutput.writeObject(usuario);

		objectOutput.close();

	}

}
