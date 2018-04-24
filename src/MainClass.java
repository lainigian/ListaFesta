
public class MainClass 
{

	public static void main(String[] args) 
	{
		Invitato i1=new Invitato ("Yuri",'M',"3398776543");
		Invitato i2=new Invitato ("Raimondo",'M',"339865436543");
		Invitato i3=new Invitato ("Laura",'F',"3398778763");
		Invitato i4=new Invitato ("Beppe",'M',"3387778763");
		Invitato i5=new Invitato ("Lilliano",'M',"3387773463");
		
		FestaCoda f1=new FestaCoda();
		f1.enqueue(i1);
		System.out.println(f1.toString());
		f1.enqueue(i2);
		System.out.println(f1.toString());
		f1.enqueue(i3);
		System.out.println(f1.toString());
		f1.enqueue(i4);
		System.out.println(f1.toString());
		f1.enqueue(i5);
		System.out.println(f1.toString());
		
		System.out.println(f1.toString());
		
		try 
		{
			while (true)
			{
				System.out.println(f1.dequeue().toString());
				System.out.println(f1.toString());
			}
			
		} 
		catch (FestaException e) 
		{
			System.out.println(e.toString());
		}
		
		
	}
	
	
	
	
	
}
