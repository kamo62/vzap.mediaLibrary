package vzap.kamo.media;

import vzap.kamo.exceptions.Media_Exception;

public class Games extends Media
{
	private String Platform, Publisher;
	public Games(String name, String genre, String year, String Platform, String Publisher) throws Media_Exception
	{
		super(name,genre,year);
		this.Platform = Platform;
		this.Publisher = Publisher;
		if(this.Platform == null || this.Platform.isEmpty())
		{
			throw new Media_Exception("The Platform field is empty");
		}
		if(this.Publisher == null || this.Publisher.isEmpty())
		{
			throw new Media_Exception("The Publisher field is empty");
		}
		
	}
	/**
	 * @return the platform
	 */
	public String getPlatform()
	{
		return Platform;
	}
	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform)
	{
		Platform = platform;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher()
	{
		return Publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher)
	{
		Publisher = publisher;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Game [Name=" + super.getName() + ",Genre=" + super.getGenre() + ",Year=" + super.getYear() + ",Platform=" + Platform + ", Publisher=" + Publisher + "]";
	}


}
