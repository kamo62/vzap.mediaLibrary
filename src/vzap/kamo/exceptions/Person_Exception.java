package vzap.kamo.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person_Exception extends Exception
{

	private String message;
	private Date date;
	private SimpleDateFormat sdf;
	
	public Person_Exception(String message)
	{
		super();
		this.message = message;
		sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss Z G");
		date = new Date();
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage()
	{
		// TODO Auto-generated method stub
		return this.message + "\t" + sdf.format(date);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Person_Exception [message=" + message + ", date=" + sdf.format(date)+"]";
	}
	
	
	

}
