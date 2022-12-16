package focuscursos.servicos;

import java.io.IOException;
import java.util.List;

import focuscursos.model.entidade.Aula;
import focuscursos.model.persistencia.GenericArquivo;

public class AulaServico {

	private GenericArquivo<Aula> persistencia = new GenericArquivo<>();

	public void gravarAnotacao(Aula aula) throws ClassNotFoundException, IOException {
		persistencia.cadastrar(aula, "arquivos/arquivoAnotacao.fc");
	}
	
	public String obterAnotacaoDaAula(Aula aulaAtual) throws ClassNotFoundException, IOException {
		List<Aula> aulas = persistencia.obterElementosCadastrados("arquivos/arquivoAnotacao.fc");
		
		for (Aula aula : aulas) {
			if(aulaAtual.equals(aulaAtual)) {
				return aula.getAnotacoes();
			}
		}
		
		return "";
		
	}

}
