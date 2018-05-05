import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Festa implements Serializable
{

	private Nodo head;
	private int elementi;
	
	public Festa()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo creaNodo(Invitato persona, Nodo link)
	{
		Nodo nodo= new Nodo(persona);
		nodo.setLink(link);
		return nodo;
	}
	
	private Nodo getLinkPosizione(int posizione) throws FestaException
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;
		
		if (posizione<1 || posizione>getElementi())
			throw new FestaException("Posizione non valida");
		if (elementi==0)
			throw new FestaException("Lista vuota");
			
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	//p va a puntare al nodo successivo
			n++;
		}
		
		return p;
	}
	
	public void inserisciInTesta (Invitato persona)
	{
		
		Nodo p=creaNodo(persona, head);
		head=p;
		elementi++;
	}
	
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	
	public void inserisciInCoda(Invitato persona) throws FestaException
	{
		if(elementi==0)
		{
			inserisciInTesta(persona);
			return;
		}
		
		Nodo pn=creaNodo(persona, null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;	
	}
	
	public void inseriscInPosizione(Invitato persona,int posizione) throws FestaException
	{
		if (posizione<=1)
		{
			inserisciInTesta(persona);
			return;
		}
		if (posizione>elementi)
		{
			inserisciInCoda(persona);
			return;
		}
		
		Nodo pn=creaNodo(persona, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(pn);
		elementi++;
	}
	
	public void eliminaInTesta() throws FestaException
	{
		if (elementi==0)
			throw new FestaException("Lista vuota");
		head=head.getLink();
		elementi--;
	}
	
	public void eliminaInCoda() throws FestaException
	{
		if (elementi==0)
			throw new FestaException("Lista vuota");
		if (elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	
	public void eliminaInPosizione(int posizione) throws FestaException
	{
		if (elementi==0)
			throw new FestaException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new FestaException("Posizione non valida");
	
		if (posizione==1)
		{
			eliminaInTesta();
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	
	public String visita (int posizione) throws FestaException
	{
		if (elementi==0)
			throw new FestaException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new FestaException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo().toString();		
	}
	
	public Invitato getInvitato (int posizione) throws FestaException
	{
		if (elementi==0)
			throw new FestaException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new FestaException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	public void esportaCSV (String nomeFile) throws IOException, FestaException, FileException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String personaCSV;
		Invitato persona;
		
		for (int i = 1; i <= getElementi(); i++) 
		{
			persona=getInvitato(i);
			personaCSV=persona.getNome()+";"+persona.getSesso()+";"+persona.getTelefono()+";";
			file.toFile(personaCSV);
		}
		file.closeFile();
		
	}

	public Festa importaCSV (String nomeFile) throws IOException, FileException, FestaException
	{
		Festa festa=new Festa();
		TextFile file=new TextFile(nomeFile,'R');
		String rigaLetta;
		String[] elementiPersona;
		Invitato persona;
		
			try 
			{
				while(true)
				{
					rigaLetta=file.fromFile();
					elementiPersona=rigaLetta.split(";");
					persona=new Invitato(elementiPersona[0],elementiPersona[1].charAt(0),elementiPersona[2]);
					festa.inserisciInCoda(persona);
				}
				
			} 
			catch (FileException e) 
			{
				if (e.toString().compareTo("End of file")==0)
					file.closeFile();
				else
					throw new FileException(e.toString());
			}
		
			return festa;		
			
	}
	public void salvaFesta(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	public Festa caricaFesta (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Festa festa;
		
		festa=(Festa)(reader.readObject());
		file.close();
		return festa;
	}
}
