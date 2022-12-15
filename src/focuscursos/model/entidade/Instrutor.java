
package focuscursos.model.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Instrutor extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cnpj;
	private List<Curso> cursoCadastrados = new ArrayList<Curso>();

	public Instrutor() {

	}

	public Instrutor(String nome, String email, String senha, String telefone, String sobrenome, String cpf) {
		super(nome, email, senha, telefone, sobrenome, cpf);
	}

	public Instrutor(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Curso> getCursoCadastrados() {
		return cursoCadastrados;
	}

	@Override
	public List<Curso> getCursos() {
		return cursoCadastrados;
	}

}
