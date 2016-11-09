package vzap.kamo.media;

public class DummyCode
{

	public DummyCode()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
	{	int counter = 200;
		for (int i = 0; i < 11; i++)
		{
			System.out.println("i = "+ i);
			try
			{
				Thread.sleep(counter);
				counter+= 200;
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //static method
			
		}

	}

}
