
package focuscursos.model.entidade;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String sobrenome;

	public Usuario() {

	}

	public Usuario(String nome, String email, String senha, String telefone, String sobrenome) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.sobrenome = sobrenome;
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

}
