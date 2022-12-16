
package focuscursos.model.entidade;

import java.io.Serializable;

public class Aula implements Serializable {

	private static final long serialVersionUID = 1L;

	private String titulo;
	private String linkVideo;
	private String anotacoes;
	private MaterialDeApoio materialDeApoio;

	public Aula() {

	}

	public Aula(String titulo, String linkVideo, String anotacoes, MaterialDeApoio materialDeApoio) {
		this.titulo = titulo;
		this.linkVideo = linkVideo;
		this.anotacoes = anotacoes;
		this.materialDeApoio = materialDeApoio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public MaterialDeApoio getMaterialDeApoio() {
		return materialDeApoio;
	}

	public void setMaterialDeApoio(MaterialDeApoio materialDeApoio) {
		this.materialDeApoio = materialDeApoio;
	}

	@Override
	public String toString() {
		return titulo;
	}

}
