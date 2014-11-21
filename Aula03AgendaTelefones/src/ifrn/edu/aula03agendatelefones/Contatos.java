package ifrn.edu.aula03agendatelefones;

import java.util.ArrayList;

public class Contatos extends ArrayList<Contato>{
	
	private static final long serialVersionUID = 1L;
	
	public void inserir(String aNome, String aFone) {
		Contato c = new Contato(aNome, aFone); 
		this.add(c); 
	}
	
	public Boolean editar(String aNome, String aFone) {
		Boolean result = false;
		for (Contato c : this)
			if(c.getNome().equals(aNome)) {
				c.setFone(aFone);
				result = true;
				break; 
			}
		
		return result; 
	}
	
	public Boolean excluir(String aNome, String aFone) {
		Boolean result = false;
		for (Contato c : this)
			if(c.getNome().equals(aNome)) {
				this.remove(c);
				result = true;
				break; 
			}
		return result;
	}
	
	public String toString() {
		String result = "";
		for (Contato c : this)
			result += c.toString() + "\n";
		return result;
	}
	
}