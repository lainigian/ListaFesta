import java.io.IOException;

public class MainClass 
{

	public static void main(String[] args) 
	{
		
		
		Festa f2=new Festa();
		try 
		{
			f2=f2.caricaFesta("festa.bin");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Impossibile caricare oggetti di tipo festa");
		} 
		catch (IOException e) 
		{
			System.out.println("Impossibile leggere da file");
		}
		
		System.out.println(f2.toString());
	/*	System.out.println(f1.toString());
		try 
		{
			f1.esportaCSV("festa.txt");
			System.out.println("esportazione eseguita correttamente");
		} 
		catch (IOException e) 
		{
			System.out.println("Impossibile scrivere sul file");
		} 
		catch (FestaException e) 
		{
			System.out.println(e.toString());
		} 
		catch (FileException e) 
		{
			System.out.println(e.toString());
		}
		
		Festa f2=new Festa();
		try 
		{
			f2=f2.importaCSV("festa.txt");
		} 
		catch (IOException e) 
		{
			System.out.println("Impossibile leggere dal file");
		} 
		catch (FileException e) 
		{
			System.out.println(e.toString());
		} 
		catch (FestaException e) 
		{
			System.out.println(e.toString());
		}
		
		System.out.println(f2.toString());
	*/
	
	}
	
	
	
	
	
}
