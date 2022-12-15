package focuscursos.model.persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import focuscursos.model.entidade.Curso;
import focuscursos.model.entidade.Instrutor;

public class ArquivoCurso {

	private static final String CAMINHO_ARQUIVO = "arquivos/arquivoCurso.fc";

	public Curso buscarCursoPorTitulo(String titulo) throws IOException, ClassNotFoundException {

		FileInputStream fileInput = new FileInputStream(CAMINHO_ARQUIVO);
		List<Curso> listaCursos = new ArrayList<>();

//		try (ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
//			listaCursos = (List<Curso>) objectInput.readObject();
//		} catch (EOFException e) {
//			listaCursos = null;
//		}
		
		// TODO remover essa lista
		listaCursos.add(new Curso("Java - orientacao a objt", "Que nada ", "/focuscursos/view/capacurso/Img1.jpg",
				new Instrutor()));
		listaCursos.add(new Curso("Python - orientacao", "dasdsccxzcxc   xzczxa ",
				"/focuscursos/view/capacurso/Img2.jpg", new Instrutor()));
		listaCursos.add(new Curso("C - orientacao a lista", "adsadsdasd ", "/focuscursos/view/capacurso/Img3.jpg",
				new Instrutor()));
		listaCursos.add(
				new Curso("Javascript", "Linguagem de doido", "/focuscursos/view/capacurso/Img4.jpg", new Instrutor()));
		listaCursos.add(new Curso("Cobol", "Ddjjiajljekd ", "/focuscursos/view/capacurso/Img5.jpg", new Instrutor()));
		listaCursos.add(new Curso("Ruby - Curso completo", "Que nada rapa", "/focuscursos/view/capacurso/Img6.jpg",
				new Instrutor()));
		listaCursos.add(
				new Curso("Adm - muda nada", "Que nada ", "/focuscursos/view/capacurso/Img7.jpg", new Instrutor()));
		listaCursos.add(new Curso("engenharia muda o que?", "dasdsccxzcxc   xzczxa ",
				"/focuscursos/view/capacurso/Img8.jpg", new Instrutor()));
		listaCursos.add(new Curso("Churrascaria orientada a calculo 4", "adsadsdasd ",
				"/focuscursos/view/capacurso/Img9.jpg", new Instrutor()));
		listaCursos.add(new Curso("Chesperito mostra como bater martelo", "Linguagem de doido",
				"/focuscursos/view/capacurso/Img10.jpg", new Instrutor()));
		listaCursos.add(new Curso("Chaves ensina curso de pandeiro", "Ddjjiajljekd ",
				"/focuscursos/view/capacurso/Img5.jpg", new Instrutor()));
		listaCursos.add(new Curso("O rei leão ensinando javascript - orientacao a objt", "Que nada ",
				"/focuscursos/view/capacurso/Img1.jpg", new Instrutor()));

//		if (listaCursos == null) {
//			return null;
//		}

		Curso result = null;

		for (Curso curso : listaCursos) {
			if (curso.getTitulo().equals(titulo)) {
				result = curso;
				break;
			}
		}

		fileInput.close();

		return result;
	}
	
	

}
