package focuscursos.model.persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericArquivo<T extends Serializable> {
	
	List<T> listaElementos;
	
	public void cadastrar(T t, String caminhoArquivo) throws ClassNotFoundException, IOException {
		listaElementos = obterElementosCadastrados(caminhoArquivo);

		if (listaElementos == null) {
			listaElementos = new ArrayList<>();
		}

		FileOutputStream fileOutput = new FileOutputStream(caminhoArquivo);
		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

		listaElementos.add(t);
		objectOutput.writeObject(listaElementos);

		objectOutput.close();
		fileOutput.close();
	}
	
	public List<T> obterElementosCadastrados(String caminhoArquivo) throws IOException, ClassNotFoundException {

		FileInputStream fileInput = new FileInputStream(caminhoArquivo);

		List<T> elementos = null;

		try (ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
			elementos = (List<T>) objectInput.readObject();
		} catch (EOFException e) {
			elementos = null;
		}

		fileInput.close();

		return elementos;
	}
	

}
