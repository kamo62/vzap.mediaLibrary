package vzap.kamo.media;

import java.util.ArrayList;

import vzap.kamo.daos.FileMediaDAO;
import vzap.kamo.daos.FileUserDAO;
import vzap.kamo.exceptions.Media_Exception;

public class Catalogue
{
	private ArrayList<CatalogueItem> listMedia;	
	private FileMediaDAO fileMediaDao;

	public Catalogue()
	{
		listMedia = new ArrayList<CatalogueItem>();
		fileMediaDao = new FileMediaDAO();
		listMedia = fileMediaDao.getCatalogueItems();
	}

	public Catalogue(String userName)
	{
		listMedia = new ArrayList<CatalogueItem>();
		fileMediaDao = new FileMediaDAO();
		listMedia = fileMediaDao.getCatalogueItems();

		listMedia = this.getCatalogueForUser(userName);

	}

	public boolean addToCatalogue(CatalogueItem newAddition)
	{
		boolean tf = false;
		try
		{
			listMedia.add(newAddition);
			fileMediaDao.saveCatalogueItems(listMedia);
			tf = true;
		} catch (Exception ex)
		{

		}
		return tf;
	}

	public ArrayList<CatalogueItem> getListMedia()
	{
		return listMedia;
	}

//	public void setCatalogueItemMedia(int listIndex, Media mediaItem)
//	{
//		this.listMedia.get(listIndex).setMediaItem(mediaItem);
//	}
//
//	public void setCatalogueItemUserName(int listIndex, String userName)
//	{
//		this.listMedia.get(listIndex).setUserName(userName);
//	}
//
//	public String getCatalogueItemUserName(int listIndex, String userName)
//	{
//		return this.listMedia.get(listIndex).getUserName();
//	}

	public Media getCatalogueItemMedia(int listIndex, String userName)
	{
		return this.listMedia.get(listIndex).getMediaItem();
	}

	public ArrayList<CatalogueItem> getCatalogueForUser(String userName)
	{
		ArrayList<CatalogueItem> newList = new ArrayList<CatalogueItem>();
		for (CatalogueItem catalogueItem : listMedia)
		{
			if (catalogueItem.getUserName().equalsIgnoreCase(userName))
			{
				newList.add(catalogueItem);
			}
		}
		return newList;
	}

	public void saveCatalogue(ArrayList<CatalogueItem> items)
	{
		fileMediaDao.saveCatalogueItems(items);
	}
}
