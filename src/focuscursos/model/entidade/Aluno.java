
package focuscursos.model.entidade;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
	private String cpf;
	private List<Curso> cursoAdquiridos = new ArrayList<Curso>();

	public Aluno() {

	}

	public Aluno(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Curso> getCursoAdquiridos() {
		return cursoAdquiridos;
	}
	
	

}
