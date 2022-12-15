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

import focuscursos.model.entidade.Usuario;
import focuscursos.model.persistencia.exception.UsuarioNaoEncontradoException;

public class GenericArquivo<E extends Serializable> {

	List<E> listaElementos;

	public void cadastrar(E e, String caminhoArquivo) throws ClassNotFoundException, IOException {
		listaElementos = obterElementosCadastrados(caminhoArquivo);

		if (listaElementos == null) {
			listaElementos = new ArrayList<>();
		}

		FileOutputStream fileOutput = new FileOutputStream(caminhoArquivo);
		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

		listaElementos.add(e);
		objectOutput.writeObject(listaElementos);

		objectOutput.close();
		fileOutput.close();
	}

	public List<E> obterElementosCadastrados(String caminhoArquivo) throws IOException, ClassNotFoundException {

		FileInputStream fileInput = new FileInputStream(caminhoArquivo);

		List<E> elementos = null;

		try (ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
			elementos = (List<E>) objectInput.readObject();
		} catch (EOFException e) {
			elementos = null;
		}

		fileInput.close();

		return elementos;
	}

	public void atualizarElemento(E elementoAntigo, E novoElemento, String caminhoArquivo)
			throws ClassNotFoundException, IOException, UsuarioNaoEncontradoException {
		List<E> elementos = obterElementosCadastrados(caminhoArquivo);

		if (elementos == null) {
			throw new UsuarioNaoEncontradoException("Erro! usuario não encontrado!");
		}

		int indexElemento = elementos.indexOf(elementoAntigo);

		elementos.set(indexElemento, novoElemento);

		FileOutputStream fileOutput = new FileOutputStream(caminhoArquivo);
		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

		objectOutput.writeObject(elementos);

		objectOutput.close();
		fileOutput.close();
	}

}
