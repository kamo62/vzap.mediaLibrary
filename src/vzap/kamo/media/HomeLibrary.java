package vzap.kamo.media;

import java.util.ArrayList;
import vzap.kamo.exceptions.Media_Exception;
import vzap.kamo.exceptions.Person_Exception;
import vzap.kamo.persons.User;

public class HomeLibrary
{

	private Login login;
	private String username, password;
	private EasyIn input;
	private boolean verified;
	private User user;
	private Catalogue userCatalogue;
	private CatalogueItem newCatalogueItem;

	private int counter;
	/**
	 * Constructor
	 */
	public HomeLibrary()
	{
		userCatalogue = new Catalogue();
		login = new Login();
		verified = false;
		input = new EasyIn();
		System.out.println("Welcome to the Library System....>>>>>");
		counter=0;
		
		
		while(counter<=2)
		{
			System.out.println("Enter your User Name:");
			username = input.readString();
			System.out.println("Enter your Password:");
			password = input.readString();
			verified = login.verify(username,password);
			
			if(verified)
			{
				System.out.println("Access Granted. Welcome !");
				System.out.println();
				user = login.returnUser(username,password);
				System.out.println();
				break;
			}
			else
			{
				if(counter<2)
				{
					System.out.println("You either don't have access or incorrect details");
					System.out.println();
					counter++;
					continue;
				}
				else
				{
					System.out.println("You have entered the wrong details to many times");
					System.out.println("Exiting... >>>>>>>>>>>>>");
					System.exit(0);
				}
				
			}
		}//end of while loop
		if(user.isAdmin())
		{
			printAdminScreen();
		}
		else
		{
			printUserScreen();
		}
	}
	
	private void userSelection(int id)
	{
		switch(id)
		{
			case 1: AddUser();
					break;
			case 2: ManageUser();
					break;
			case 3: deleteUser();
					break;
			case 4 :printListMedia();
					break;
			case 5: addNewMedia();
					break;
			case 6: manageMedia();
					break;
			case 7: deleteMedia();
					break;
			case 8: printSystemExit();
					break;
			default : break;
		}
	}
	
	private void printListMedia()
	{
		System.out.println("List of Media for " + user.getName());
		System.out.println();
		for (CatalogueItem item : userCatalogue.getListMedia())
		{
			System.out.println(item.getMediaItem().toString());
		}
		System.out.println();
		printScreens();
	}

	private void printSystemExit()
	{
		System.out.println("Confirm you want to exit the program. Y/N");
		char decide = input.readChar();
		if(decide =='Y')
		{
			System.out.println("Exiting... >>>>>>>>>>>>>");
			System.exit(0);
		}
		else
		{
			printScreens();
		}
		
	}

	private void deleteUser()
	{
		int userSelection, userCounter = 0;
		ArrayList<User> userList = login.getUserCatalog();
		for(User item: userList)
		{
			System.out.println("["+userCounter+"] :" + item.getName() + " " + item.getPassword());
		}
		System.out.println();
		System.out.println("Please enter the user you would like to manage.");
		userSelection = input.readInt();
		
		System.out.println();
		System.out.println("You selected user: " + userList.get(userSelection).getName() + " " 
												 + userList.get(userSelection).getPassword());		
		
		System.out.println("Please confirm if you would still like to delete user. Y/N");
		char isDeleted = input.readChar();
		if(isDeleted=='Y')
		{
			if(userList.get(userSelection).isAdmin())
			{
				System.out.println("Please confirm if you want to delete an Admin. Y/N");
				char isDeleteAdmin = input.readChar();
				if(isDeleteAdmin=='Y')
				{
					login.deleteUser(userSelection);
					System.out.println("You've succesfully deleted the user");
				}
			}
			else
			{
				login.deleteUser(userSelection);
				System.out.println("You've succesfully deleted the user");
			}
		}
		printScreens();
	}

	private void AddUser()
	{
		while(true)
		{
			// TODO Auto-generated method stub
			System.out.println();
			System.out.println("You have selected to add a new user");
			System.out.println();
			System.out.println("Please enter the Name of user");
			String name = input.readString();
			System.out.println("Please enter the Surname of user");
			String surname = input.readString();
			System.out.println("Please enter the User Name of user");
			String username = input.readString();
			System.out.println("Please enter the Password of user");
			String password = input.readString();
			System.out.println("Is the User an Admin? Y/N");
			boolean isAdministrator = false;
			char admin = input.readChar();
			if(admin=='Y')
			{
				isAdministrator = true;
			}
			
			User newUser;
			try
			{
			  newUser = new User(name,surname,username,password,isAdministrator);
			  boolean userAdded = login.addUser(newUser);
			  if(!userAdded)
				{
					System.out.println("User was added successfully");
					break;
				} else
				{
					System.out.println("The username and password are the same. Please enter details again");
					continue;
				}
			} catch (Person_Exception e)
			{
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
		}
		printScreens();
	}
	
	private void printScreens()
	{
		if(user.isAdmin())
		{
				this.printAdminScreen();
		}
		else
		{
			this.printUserScreen();
		}		
	}

	private void ManageUser()
	{
			// TODO Auto-generated method stub
			int userSelection, userCounter = 0;
			ArrayList<User> userList = login.getUserCatalog();
			for(User item: userList)
			{
				System.out.println("["+userCounter+"] :" + item.getName() + " " + item.getPassword());
				userCounter++;
			}
			System.out.println();
			System.out.println("Please enter the user you would like to manage.");
			userSelection = input.readInt();
			
			System.out.println();
			System.out.println("You selected user: " + userList.get(userSelection).getName() + " " 
													 + userList.get(userSelection).getPassword());				
			System.out.println();
			System.out.println("Please enter the new Name. Please leave empty if stays the same.");
			String newName = input.readString();
			System.out.println("Please enter the new Surname. Please leave empty if stays the same.");
			String newSurname = input.readString();
			System.out.println("Please enter the new User Name. Please leave empty if stays the same.");
			String newUsername = input.readString();
			System.out.println("Please enter the new Password. Please leave empty if stays the same.");
			String newPassword = input.readString();
			System.out.println("is the User and admin? Y/N");
			char isAdmin = input.readChar();
			boolean newIsAdministrator = false;
			if(isAdmin=='Y')
			{
				newIsAdministrator = true;
			}
			if(!newName.isEmpty())
			{
				userList.get(userSelection).setName(newName);
			}
			if(!newSurname.isEmpty())
			{
				userList.get(userSelection).setSurname(newSurname);
			}
			if(!newUsername.isEmpty())
			{
				userList.get(userSelection).setUsername(newUsername);
			}
			if(!newPassword.isEmpty())
			{
				userList.get(userSelection).setPassword(newPassword);
			}
			userList.get(userSelection).setAdmin(newIsAdministrator);
			login.modifyUser(userList);
			System.out.println("You've updated the user details successfully");
			printScreens();

	}

	private void printAdminScreen()
	{
		System.out.println("---------------------------------------------------");
		System.out.println("|   Please select an option                       |");
		System.out.println("|                                                 |");
		System.out.println("|   1. Add a user                                 |");
		System.out.println("|   2. Modify a user                              |");
		System.out.println("|   3. Delete a user                              |");
		System.out.println("---------------------------------------------------");
		this.printUserScreen();
	}
	
	private void printUserScreen()
	{
		System.out.println("----------- General User Options ------------------");
		System.out.println("   Please select an option                         ");
		System.out.println("   4. List Media                                   ");
		System.out.println("   5. Add media                                    ");
		System.out.println("   6. Modify a media record                        ");
		System.out.println("   7. Delete a media record                        ");
		System.out.println("   8. Exit                                         ");
		System.out.println("---------------------------------------------------");
	}
	
	private void deleteMedia()
	{
		if(userCatalogue == null)
		{	userCatalogue = new Catalogue(user.getUsername());}
		
		int userSelection, userCounter = 0;
		ArrayList<CatalogueItem> catalogueList = userCatalogue.getListMedia();
		
		for(CatalogueItem item: catalogueList)
		{
			System.out.println("["+userCounter+"] : " +  item.getMediaItem().toString());
			userCounter++;
		}
		System.out.println();
		System.out.println("Please enter the Media you would like to manage.");
		userSelection = input.readInt();
		
		System.out.println("Please confirm if you would still like to delete media. Y/N");
		char isDeleted = input.readChar();
		if(isDeleted=='Y')
		{
			try
			{
				catalogueList.remove(userSelection);
				userCatalogue.saveCatalogue(catalogueList);
				System.out.println("You have successfully deleted the record");
			}
			catch(Exception ex)
			{
				System.out.println("An error occured");
			}
		}
		printScreens();
		
	}

	private void manageMedia()
	{
		String name,genre,year,artist,platform,albumName,publisher,director,leadActor,type;
		
		if(userCatalogue == null)
		{	userCatalogue = new Catalogue(user.getUsername());}
		int userSelection, userCounter = 0;
		Media mediaItem;
		ArrayList<CatalogueItem> catalogueList = userCatalogue.getListMedia();
		
		for(CatalogueItem item: catalogueList)
		{
			System.out.println("["+userCounter+"] : " +  item.getMediaItem().toString());
			userCounter++;
		}
		System.out.println("[99] Exit to Main screen");
		System.out.println();
		System.out.println("Please enter the Media you would like to manage.");
		userSelection = input.readInt();
		
		if(userSelection == 99)
		{
			printScreens();
			return;
		}
		
		try
		{
			System.out.println();
			System.out.println("You selected media: " + catalogueList.get(userSelection).getMediaItem().getName() + " " 
													 + catalogueList.get(userSelection).getMediaItem().getGenre()+ " "
													 + catalogueList.get(userSelection).getMediaItem().getYear());
		} catch (Exception e1)
		{
			// TODO Auto-generated catch block
			System.out.println("The number entered is not in the list of options");
			System.out.println("Returning to main screen >>>>>");
			printScreens();
		}	
		
		
		System.out.println();
		System.out.println("You have selected to add a new media");
		System.out.println();
		System.out.println("Please enter the Name of Media");
		name = input.readString();
		System.out.println("Please enter the Genre of Media");
		genre = input.readString();
		System.out.println("Please enter the Year of Media");
		year = input.readString();
		if(catalogueList.get(userSelection).getMediaItem() instanceof Music)
		{
			System.out.println("Please enter the Artist Name");
			artist = input.readString();
			System.out.println("Please enter the Album Name");
			albumName = input.readString();
			
			try
			{
				mediaItem = new Music(name, genre, year, albumName, artist);
				catalogueList.get(userSelection).setMediaItem(mediaItem);
				userCatalogue.saveCatalogue(catalogueList);
				System.out.println("Media item successfully added!");
			} catch (Media_Exception e)
			{
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
		}
		if(catalogueList.get(userSelection).getMediaItem() instanceof Video)
		{
			System.out.println("Please enter the Director Name");
			director = input.readString();
			System.out.println("Please enter the Lead Actor Name");
			leadActor = input.readString();
			System.out.println("Please enter the Media Type ie.DVD,BluRay etc");
			type = input.readString();
			try
			{
				mediaItem = new Video(name, genre,year,director,leadActor, type);
				catalogueList.get(userSelection).setMediaItem(mediaItem);
				userCatalogue.saveCatalogue(catalogueList);
				System.out.println("Media item successfully added!");
			} catch (Media_Exception e)
			{
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		if(catalogueList.get(userSelection).getMediaItem() instanceof Games)
		{
			System.out.println("Please enter the Publisher Name");
			publisher = input.readString();
			System.out.println("Please enter the Platform type ie. Console,PC,HandHeld");
			platform = input.readString();
			try
			{
				mediaItem = new Games(name, genre, year, platform, publisher);
				catalogueList.get(userSelection).setMediaItem(mediaItem);
				userCatalogue.saveCatalogue(catalogueList);
				System.out.println("Media item successfully added!");
			} catch (Media_Exception e)
			{
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		
		printScreens();
		
	}

	private void addNewMedia()
	{
		String name,genre,year,artist,platform,albumName,publisher,director,leadActor,type;
		Video newVideo;
		Games newGame;
		Music newMusic;
		userCatalogue = new Catalogue();
		
		while(true)
		{
			// TODO Auto-generated method stub
			System.out.println();
			System.out.println("You have selected to add a new media");
			System.out.println();
			System.out.println("Please enter the Name of Media");
			name = input.readString();
			System.out.println("Please enter the Genre of Media");
			genre = input.readString();
			System.out.println("Please enter the Year of Media");
			year = input.readString();
			System.out.println("What type of Media? M for Music, G for Game and V for Video");
			char mediaType = input.readChar();
			if(mediaType=='M')
			{
				System.out.println("Please enter the Artist Name");
				artist = input.readString();
				System.out.println("Please enter the Album Name");
				albumName = input.readString();
				try
				{
				  newMusic = new Music(name, genre, year, albumName, artist);
				  newCatalogueItem = new CatalogueItem(newMusic, user.getUsername());
				  boolean itemAdded = userCatalogue.addToCatalogue(newCatalogueItem);
				 
				  if(itemAdded)
					{
						System.out.println("Media Item was added successfully");
						userCatalogue.saveCatalogue(userCatalogue.getListMedia());
						break;
					} else
					{
						System.out.println("There was an issue adding the media. Please enter details again");
						continue;
					}
				} 
				catch (Media_Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(mediaType=='G')
			{
				System.out.println("Please enter the Publisher Name");
				publisher = input.readString();
				System.out.println("Please enter the Platform type ie. Console,PC,HandHeld");
				platform = input.readString();
				try
				{
					newGame = new Games(name, genre, year, platform, publisher);
					newCatalogueItem = new CatalogueItem(newGame, user.getUsername());
					boolean itemAdded = userCatalogue.addToCatalogue(newCatalogueItem);
					  if(itemAdded)
						{
							System.out.println("Media Item was added successfully");
							userCatalogue.saveCatalogue(userCatalogue.getListMedia());
							break;
						} else
						{
							System.out.println("There was an issue adding the media. Please enter details again");
							continue;
						}
				} 
				catch (Media_Exception e)
				{
					// TODO Auto-generated catch block
					e.getMessage();
				}
			}
			if(mediaType=='V')
			{
				// Director,leadActor,type;
				System.out.println("Please enter the Director Name");
				director = input.readString();
				System.out.println("Please enter the Lead Actor Name");
				leadActor = input.readString();
				System.out.println("Please enter the Media Type ie.DVD,BluRay etc");
				type = input.readString();
				try
				{
					newVideo = new Video(name, genre, year, director, leadActor, type);
					newCatalogueItem = new CatalogueItem(newVideo, user.getUsername());
					
					boolean itemAdded = userCatalogue.addToCatalogue(newCatalogueItem);
					  if(itemAdded)
						{
							System.out.println("Media Item was added successfully");
							userCatalogue.saveCatalogue(userCatalogue.getListMedia());
							break;
						} else
						{
							System.out.println("There was an issue adding the media. Please enter details again");
							continue;
						}
				} catch (Media_Exception e)
				{
					// TODO Auto-generated catch block
					e.getMessage();
				}
			}	
			
		}
		printScreens();
	}
	
	public static void main(String[] args)
	{
		HomeLibrary h1 = new HomeLibrary();
		while(true)
		{
			EasyIn programInput = new EasyIn();
			int selection = programInput.readInt();
			h1.userSelection(selection);
		}
	}

}
