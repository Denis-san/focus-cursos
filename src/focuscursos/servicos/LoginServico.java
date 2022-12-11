package focuscursos.servicos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import focuscursos.model.entidade.Usuario;

public class LoginServico {
	
	
	//fic
	
	List<Usuario> cadastros = new ArrayList<Usuario>();
	
	
	
	//end
	
	 
	
	
	
	public boolean fazerLogin(String email, String senha) {

		cadastros.add(new Usuario("Joaquin", "joaquin@mail.com", "joaquinxixi123", "445444755", "Medeiros"));
		cadastros.add(new Usuario("Joao", "joao@mail.com", "joao123", "7897897", "Souza"));
		cadastros.add(new Usuario("Nilso", "nilso@mail.com", "nilso23", "4464546", "SIlva"));
		cadastros.add(new Usuario("Aliso", "aliso@mail.com", "aliso123", "98797897", "XAma"));

		for (Usuario usuario : cadastros) {
			
			if(usuario.getEmail().equals(email)) {
				
				if(usuario.getSenha().equals(senha)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
