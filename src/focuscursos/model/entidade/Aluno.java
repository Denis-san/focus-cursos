
package focuscursos.model.entidade;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
	
	private List<Curso> cursoAdquiridos = new ArrayList<Curso>();

	public Aluno() {

	}

	public List<Curso> getCursoAdquiridos() {
		return cursoAdquiridos;
	}
	
	

}
