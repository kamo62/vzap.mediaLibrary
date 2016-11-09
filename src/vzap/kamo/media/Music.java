/**
 * 
 */
package vzap.kamo.media;

import vzap.kamo.exceptions.Media_Exception;

public class Music extends Media
{
	private String AlbumName,Artist;
	/**
	 * 
	 */
	public Music(String name, String genre, String year, String albumName, String artist) throws Media_Exception
	{
		super(name, genre, year);
		this.AlbumName = albumName;
		this.Artist = artist;
		
		if(this.Artist == null || this.Artist.isEmpty())
		{
			throw new Media_Exception("The Artist field is empty");
		}
		if(this.AlbumName == null || this.AlbumName.isEmpty())
		{
			throw new Media_Exception("The AlbumName field is empty");
		}
	}
	/**
	 * @return the albumName
	 */
	public String getAlbumName()
	{
		return AlbumName;
	}
	/**
	 * @param albumName the albumName to set
	 */
	public void setAlbumName(String albumName)
	{
		AlbumName = albumName;
	}
	/**
	 * @return the artist
	 */
	
	public String getArtist()
	{
		return Artist;
	}
	
	public void setArtist(String artist)
	{
		Artist = artist;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Music [Name=" + super.getName() + ",Genre=" + super.getGenre() + ",Year=" + super.getYear() + ",AlbumName=" + AlbumName + ",Artist=" + Artist + "]";
	}
	
	

}
