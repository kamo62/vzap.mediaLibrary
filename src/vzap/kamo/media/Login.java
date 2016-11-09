package vzap.kamo.media;
import java.util.ArrayList;

import vzap.kamo.daos.FileUserDAO;
import vzap.kamo.exceptions.Person_Exception;
import vzap.kamo.persons.User;

public class Login 
{
	private ArrayList<User> userCatalog;
	private FileUserDAO fileUserDao;
	/*
	 * Constructor
	 */
	public Login() 
	{
		fileUserDao = new FileUserDAO();
		userCatalog = fileUserDao.LoadUsers();
//		userCatalog = new ArrayList<User>();
//		//Demonstration purpose only. This is hard coding which is only for testing.
//		
//		try
//		{
//			userCatalog.add(new User("Kamogelo","Mashishi","kamom","moo",true));
//			userCatalog.add(new User("Brian","Stark","brians","1234",false));
//			userCatalog.add(new User("Kirk","De Villiers","kirkd,","1234",false));
//			userCatalog.add(new User("Anna","Findlay","annaf","1234",false));
//		} 
//		catch (Person_Exception e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

	public boolean verify(String username, String password)
	{
		boolean valid = false;
		
		for(User u : userCatalog)
		{
			String n,p;
			n = u.getUsername();
			p = u.getPassword();
			if(n.equals(username) && p.equals(password))
			{
				valid = true;
			}
		}
		return valid;
	}
	
	public User returnUser(String username,String password)
	{
		User newUser = null;
		for(User u : userCatalog)
		{
			String n,p;
			n = u.getUsername();
			p = u.getPassword();
			if(n.equals(username) && p.equals(password))
			{
				newUser = u; 
			}
		}
		return newUser;
	
	}
	
	
	
	/**
	 * @return the userCatalog
	 */
	public ArrayList<User> getUserCatalog()
	{
		return userCatalog;
	}

	/**
	 * @param userCatalog the userCatalog to set
	 */
	public void setUserCatalog(ArrayList<User> userCatalog)
	{
		this.userCatalog = userCatalog;
	}

	public boolean addUser(User newUser)
	{
		boolean duplicateCheck = this.verify(newUser.getUsername(), newUser.getPassword());
		if(!duplicateCheck)
		{
			userCatalog.add(newUser);
		}
		return duplicateCheck; //returns false if the value was added. Returns true if there is an issue.
	}

	public void deleteUser(int userSelection)
	{
		userCatalog.remove(userSelection);
		//this removes the item and shifts the array to the left. ie: item 4 is now item 3.
		
	}

}
