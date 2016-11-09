package vzap.kamo.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Media_Exception extends Exception
{
	private String message;
	private Date date;
	private SimpleDateFormat sdf;
	
	public Media_Exception(String message)
	{
		super();
		this.message = message;
		sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss Z G");
		date = new Date();
	}

	@Override
	public String getMessage()
	{
		// TODO Auto-generated method stub
		return this.message + "\t" + sdf.format(date);
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return super.toString();
	}

	
}
