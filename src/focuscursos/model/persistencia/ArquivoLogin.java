package focuscursos.model.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class ArquivoLogin {

	public boolean verificarLogon() throws IOException, ClassNotFoundException {
		Boolean result;

		try {
			FileInputStream fileInput = new FileInputStream("arquivos/arquivoLogin.fc");

			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			result = (boolean) objectInput.readObject();

			objectInput.close();
		} catch (StreamCorruptedException | FileNotFoundException e) {
			registrarLogin(false);
			result = false;
		}
		
		return result;
	}

	public void registrarLogin(Boolean logar) throws IOException {

		FileOutputStream fileOutput = new FileOutputStream("arquivos/arquivoLogin.fc");

		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

		objectOutput.writeObject(logar);

		objectOutput.close();

	}

}
