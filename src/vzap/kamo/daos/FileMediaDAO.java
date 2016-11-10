package vzap.kamo.daos;

import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;

import vzap.kamo.exceptions.*;
import vzap.kamo.media.*;
import vzap.kamo.persons.*;

public class FileMediaDAO
{
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private File file;
	private ArrayList<CatalogueItem> catalogueItems;

	public FileMediaDAO()
	{
		catalogueItems = new ArrayList<CatalogueItem>();
		dbFactory = DocumentBuilderFactory.newInstance();
		try
		{
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<CatalogueItem> getCatalogueItems()
	{
		try
		{
			Music newMusic;
			Video newVideo;
			Games newGame;

			file = new File("./resources/CatalogueItems.xml");
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Media");
			for (int temp = 0; temp < nList.getLength(); temp++)
			{
				Node nNode = nList.item(temp);
				// System.out.println("\nCurrent Element :" +
				// nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					String name = eElement.getElementsByTagName("Name").item(0).getTextContent();
					String genre = eElement.getElementsByTagName("Genre").item(0).getTextContent();
					String year = eElement.getElementsByTagName("Year").item(0).getTextContent();
					String type = eElement.getElementsByTagName("Type").item(0).getTextContent();
					String user = eElement.getElementsByTagName("User").item(0).getTextContent();
					if (type.equals("Music"))
					{
						String artist = eElement.getElementsByTagName("Artist").item(0).getTextContent();
						String albumName = eElement.getElementsByTagName("Album").item(0).getTextContent();
						newMusic = new Music(name, genre, year, albumName, artist);
						catalogueItems.add(new CatalogueItem(newMusic, user));
					} else if (type.equals("Video"))
					{
						String director = eElement.getElementsByTagName("Director").item(0).getTextContent();
						String leadActor = eElement.getElementsByTagName("LeadActor").item(0).getTextContent();
						String mediaType = eElement.getElementsByTagName("MediaType").item(0).getTextContent();
						newVideo = new Video(name, genre, year, director, leadActor, type);
						catalogueItems.add(new CatalogueItem(newVideo, user));
					} else if (type.equals("Games"))
					{
						String publisher = eElement.getElementsByTagName("Publisher").item(0).getTextContent();
						String platform = eElement.getElementsByTagName("Platform").item(0).getTextContent();
						newGame = new Games(name, genre, year, platform, publisher);
						catalogueItems.add(new CatalogueItem(newGame, user));
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return catalogueItems;
	}

	public void saveCatalogueItems(ArrayList<CatalogueItem> items)
	{

		try
		{
			// root elements
			Document doc = dBuilder.newDocument();
			Element rootElement = doc.createElement("Catalogue");
			doc.appendChild(rootElement);

			for (CatalogueItem catalogueItem : items)
			{
				try
				{
					// Media elements
					Element media = doc.createElement("Media");
					rootElement.appendChild(media);

					// name elements
					Element name = doc.createElement("Name");
					name.appendChild(doc.createTextNode(catalogueItem.getMediaItem().getName()));
					media.appendChild(name);

					// Genre elements
					Element genre = doc.createElement("Genre");
					genre.appendChild(doc.createTextNode(catalogueItem.getMediaItem().getGenre()));
					media.appendChild(genre);

					Element username = doc.createElement("User");
					username.appendChild(doc.createTextNode(catalogueItem.getUserName()));
					media.appendChild(username);
					
					Element year = doc.createElement("Year");
					year.appendChild(doc.createTextNode(catalogueItem.getMediaItem().getYear()));
					media.appendChild(year);
					
					if(catalogueItem.getMediaItem() instanceof Music)
					{
						Music newMusic = (Music)catalogueItem.getMediaItem();
						
						Element artist = doc.createElement("Artist");
						artist.appendChild(doc.createTextNode(newMusic.getArtist()));
						media.appendChild(artist);

						Element albumName = doc.createElement("Album");
						albumName.appendChild(doc.createTextNode(newMusic.getAlbumName()));
						media.appendChild(albumName);
						
						Element type = doc.createElement("Type");
						type.appendChild(doc.createTextNode("Music"));
						media.appendChild(type);
						
						
					}
					if(catalogueItem.getMediaItem() instanceof Video)
					{
						
						Video newVideo = (Video)catalogueItem.getMediaItem();
						
						Element director = doc.createElement("Director");
						director.appendChild(doc.createTextNode(newVideo.getDirector()));
						media.appendChild(director);

						Element leadActor = doc.createElement("LeadActor");
						leadActor.appendChild(doc.createTextNode(newVideo.getLeadActor()));
						media.appendChild(leadActor);
						
						Element type = doc.createElement("Type");
						type.appendChild(doc.createTextNode("Video"));
						media.appendChild(type);
						
						Element mediatype = doc.createElement("MediaType");
						mediatype.appendChild(doc.createTextNode(newVideo.getType()));
						media.appendChild(mediatype);
						
					}
					if(catalogueItem.getMediaItem() instanceof Games)
					{
						Games newGames = (Games)catalogueItem.getMediaItem();
						
						Element type = doc.createElement("Type");
						type.appendChild(doc.createTextNode("Games"));
						media.appendChild(type);
						
						Element publisher = doc.createElement("Platform");
						publisher.appendChild(doc.createTextNode(newGames.getPublisher()));
						media.appendChild(publisher);
						
						Element platform = doc.createElement("Publisher");
						platform.appendChild(doc.createTextNode(newGames.getPlatform()));
						media.appendChild(platform);									
					}
				} catch (Exception pce)
				{
					pce.printStackTrace();
				}

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			//set the formatting
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("./resources/CatalogueItems.xml"));

			
			
			transformer.transform(source, result);

			System.out.println("File saved!");
		} 
		catch (Exception ex)
		{
			// return false;
		}

	}

//	public static void main(String[] args)
//	{
//		FileMediaDAO dao = new FileMediaDAO();
//		ArrayList<CatalogueItem> list = dao.getCatalogueItems();
//		// for (CatalogueItem catalogueItem : list)
//		// {
//		// System.out.println(catalogueItem.toString());
//		// }
//
//		dao.saveCatalogueItems(list);
//	}
}
