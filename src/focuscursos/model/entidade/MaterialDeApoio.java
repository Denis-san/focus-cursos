
package focuscursos.model.entidade;

public class MaterialDeApoio {

	private String nome;
	private String link;

	public MaterialDeApoio() {

	}

	public MaterialDeApoio(String nome, String link) {
		this.nome = nome;
		this.link = link;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
