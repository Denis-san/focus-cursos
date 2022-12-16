package focuscursos.servicos;

import java.io.IOException;
import java.util.List;

import focuscursos.model.entidade.Curso;
import focuscursos.model.persistencia.GenericArquivo;

public class CursoServico {

	private GenericArquivo<Curso> persistencia = new GenericArquivo<>();

	public void cadastrarCurso(Curso curso) throws ClassNotFoundException, IOException {
		persistencia.cadastrar(curso, "arquivos/arquivosCursos.fc");
	}

	public List<Curso> todosOsCursos() throws ClassNotFoundException, IOException {
		return persistencia.obterElementosCadastrados("arquivos/arquivosCursos.fc");
	}

}
