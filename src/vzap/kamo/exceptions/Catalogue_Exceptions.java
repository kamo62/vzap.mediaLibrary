package vzap.kamo.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Catalogue_Exceptions extends Exception
{
	private String message;
	private Date date;
	private SimpleDateFormat sdf;

	public Catalogue_Exceptions(String message)
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

	

}
