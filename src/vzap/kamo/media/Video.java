/**
 * 
 */
package vzap.kamo.media;

import vzap.kamo.exceptions.Media_Exception;

public class Video extends Media
{
	private String Director,leadActor,type;

	/**
	 * 
	 */
	public Video(String name, String genre, String year, String director, String leadActor,String type) throws Media_Exception
	{
		super(name,genre,year);
		this.Director = director;
		this.leadActor = leadActor;
		this.type = type;
		
		if(this.Director == null || this.Director.isEmpty())
		{
			throw new Media_Exception("The Artist field is empty");
		}
		if(this.leadActor == null || this.leadActor.isEmpty())
		{
			throw new Media_Exception("The AlbumName field is empty");
		}
		if(this.type == null || this.type.isEmpty())
		{
			throw new Media_Exception("The type field is empty");
		}
		
	}

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return the director
	 */
	public String getDirector()
	{
		return Director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director)
	{
		Director = director;
	}

	/**
	 * @return the leadActor
	 */
	public String getLeadActor()
	{
		return leadActor;
	}

	/**
	 * @param leadActor the leadActor to set
	 */
	public void setLeadActor(String leadActor)
	{
		this.leadActor = leadActor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Video [Name=" + super.getName() + ",Genre=" + super.getGenre() + ", Year=" + super.getYear() + ",Director=" + Director + ",LeadActor=" + leadActor + ", Type=" + type + "]";
	}

	
	

}
