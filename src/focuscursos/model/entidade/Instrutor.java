
package focuscursos.model.entidade;

import java.util.ArrayList;
import java.util.List;

public class Instrutor extends Usuario {

	private String cnpj;
	private List<Curso> cursoCadastrados = new ArrayList<Curso>();

	public Instrutor() {

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

}
