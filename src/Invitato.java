
public class Invitato 
{

	private String nome;
	private char sesso;
	private String telefono;
	
	public Invitato(String nome, char sesso, String telefono)
	{
		setNome(nome);
		setSesso(sesso);
		setTelefono(telefono);
	}
	
	public Invitato(Invitato i)
	{
		setNome(i.getNome());
		setSesso(i.getSesso());
		setTelefono(i.getTelefono());
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSesso() {
		return sesso;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String toString()
	{
		return(getNome()+" "+getSesso()+" "+getTelefono());
	}
}
