package focuscursos.servicos;

import java.io.IOException;

import focuscursos.model.entidade.Aluno;
import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Instrutor;
import focuscursos.model.entidade.Usuario;
import focuscursos.model.persistencia.GenericArquivo;

public class CadastroServico {

//	private ArquivoCadastro persistencia = new ArquivoCadastro();

	private static final String CAMINHO_ARQUIVO = "arquivos/arquivoCadastro.fc";
	GenericArquivo<Usuario> persistencia = new GenericArquivo<>();

	public void cadastrarUsuario(Usuario usuario) throws ClassNotFoundException, IOException {

		// testess
		((Aluno) usuario).getCursoAdquiridos().add(new Curso("Ruby - Curso completo", "Que nada rapa",
				"/focuscursos/view/capacurso/Img6.jpg", new Instrutor()));
		((Aluno) usuario).getCursoAdquiridos().add(new Curso("Java - Curso completo", "Que nada rapa",
				"/focuscursos/view/capacurso/Img6.jpg", new Instrutor()));
		((Aluno) usuario).getCursoAdquiridos().add(new Curso("Python - Curso completo", "Que nada rapa",
				"/focuscursos/view/capacurso/Img6.jpg", new Instrutor()));
		((Aluno) usuario).getCursoAdquiridos().add(new Curso("C - Curso completo", "Que nada rapa",
				"/focuscursos/view/capacurso/Img6.jpg", new Instrutor()));
		Aluno a = (Aluno) usuario;
		
		persistencia.cadastrar(a, CAMINHO_ARQUIVO);

	}

}
