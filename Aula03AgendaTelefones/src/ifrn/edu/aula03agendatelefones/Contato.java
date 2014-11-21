package ifrn.edu.aula03agendatelefones;

public class Contato {
	private String nome;
	private String fone;
	
	public Contato(String aNome, String aFone) {
		nome = aNome;
		fone = aFone; 
	}
	
	public String getNome() { return nome; }
	public void setFone(String aFone) { fone = aFone; }
	@Override
	public String toString() { return nome + " - " + fone; }


}
