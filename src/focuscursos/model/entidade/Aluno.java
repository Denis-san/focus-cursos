
package focuscursos.model.entidade;

import java.io.Serializable;
import java.util.List;

public class Aluno extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Aluno() {

	}

	public Aluno(String nome, String email, String senha, String telefone, String sobrenome, String cpf) {
		super(nome, email, senha, telefone, sobrenome, cpf);
	}

	@Override
	public List<Curso> getCursos() {
		return getCursoAdquiridos();
	}

}
