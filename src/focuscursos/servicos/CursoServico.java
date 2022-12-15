package focuscursos.servicos;

import java.io.IOException;

import focuscursos.model.entidade.Curso;
import focuscursos.model.persistencia.ArquivoCurso;

public class CursoServico {

	private ArquivoCurso persistencia = new ArquivoCurso();

	public Curso obterCursoPorTitulo(String titulo) throws ClassNotFoundException, IOException {
		Curso cursoEncontrado = persistencia.buscarCursoPorTitulo(titulo);
		return cursoEncontrado;
	}

}
