/**
 * 
 */
package vzap.kamo.media;

import vzap.kamo.exceptions.Media_Exception;

public abstract class Media
{

	private String Name, Genre, Year;
	/**
	 * 
	 */
	public Media(String name, String genre, String year) throws Media_Exception
	{
		this.Name = name;
		this.Genre = genre;
		this.Year = year;
		if(this.Name.isEmpty() || this.Name == null)
		{
			throw new Media_Exception("Name is empty or null");
		}
		if(this.Name.isEmpty() || this.Name == null)
		{
			throw new Media_Exception("Name is empty or null");
		}
		if(this.Name.isEmpty() || this.Name == null)
		{
			throw new Media_Exception("Name is empty or null");
		}
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		Name = name;
	}
	/**
	 * @return the genre
	 */
	public String getGenre()
	{
		return Genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre)
	{
		Genre = genre;
	}
	/**
	 * @return the year
	 */
	public String getYear()
	{
		return Year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year)
	{
		Year = year;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Media [Name=" + Name + ", Genre=" + Genre + ", Year=" + Year +"]";
	}
	
	
 
}
