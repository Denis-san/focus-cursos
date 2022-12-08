
package focuscursos.model.entidade;

public class Curso {

	private String titulo;
	private String descricao;
	private String urlImagem;
	private Instrutor instrutor;

	public Curso() {

	}

	public Curso(String titulo, String descricao, String thumbnail, Instrutor instrutor) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.urlImagem = thumbnail;
		this.instrutor = instrutor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

}
