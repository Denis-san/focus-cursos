
package focuscursos.model.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	private String titulo;
	private String descricao;
	private String urlImagem;
	private Instrutor instrutor;
	private List<Aula> aulas = new ArrayList<>();

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

	public List<Aula> getAulas() {
		return aulas;
	}

	@Override
	public String toString() {
		return titulo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(instrutor, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(instrutor, other.instrutor) && Objects.equals(titulo, other.titulo);
	}

}
