
package focuscursos.model.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String sobrenome;
	private String cpf;

	private List<Curso> cursoAdquiridos = new ArrayList<Curso>();

	public Usuario() {

	}

	public Usuario(String nome, String email, String senha, String telefone, String sobrenome, String cpf) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getSobrenome() {
		return sobrenome;
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

	public abstract List<Curso> getCursos();

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefone=" + telefone
				+ ", sobrenome=" + sobrenome + ", cpf=" + cpf + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email);
	}

}
