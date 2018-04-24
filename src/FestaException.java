
public class FestaException extends Exception 
{
	private String messaggio;
	
	public FestaException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
