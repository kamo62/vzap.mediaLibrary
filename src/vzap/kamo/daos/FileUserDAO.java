package vzap.kamo.daos;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import vzap.kamo.exceptions.Person_Exception;
import vzap.kamo.persons.User;

public class FileUserDAO
{
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private PrintWriter pw;
	private File file;
	private ArrayList<User> users;
	private User tempUser;
	private String path;
	
	public FileUserDAO()
	{
		users = new ArrayList<User>();
		
		this.path = "./resources/Users.txt";
		file = new File(path);
	}
	
	public ArrayList<User> LoadUsers()
	{
		try
		{
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String msg;
			
			while((msg = br.readLine()) != null)
			{
				StringTokenizer str = new StringTokenizer(msg, ",");
				while(str.hasMoreTokens())
				{
					String name = str.nextToken();
					String surname  = str.nextToken();
					String username = str.nextToken();
					String password = str.nextToken();
					boolean isAdmin = Boolean.parseBoolean(str.nextToken());
					boolean isAdmin1 = true;
					tempUser = new User(name, surname, username, password, isAdmin1);
					users.add(tempUser);
				}
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Person_Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return users;
		
	}

	public void addUser(User user)
	{
		try
		{
			
			fw = new FileWriter(file);
			pw = new PrintWriter(fw); //basic connection object wrapped into a printwriter object
			
			String newStringUser = user.getName() + ","+ user.getSurname() + "," + user.getUsername() +"," 
						+ user.getPassword() + "," + user.isAdmin();
			
			pw.println(newStringUser);
			
			pw.close();
			fw.close();
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //basic connection object
		
		
		
	}
	
	public boolean SaveUsers(ArrayList<User> user)
	{
		try
		{
			
			fw = new FileWriter(file);
			pw = new PrintWriter(fw); //basic connection object wrapped into a printwriter object
			
			for (User item : user)
			{
				String newStringUser = item.getName() + ","+ item.getSurname() + "," + item.getUsername() +"," 
						+ item.getPassword() + "," + item.isAdmin();
				pw.println(newStringUser);
			}
			
			pw.close();
			fw.close();
			return true;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} //basic connection object
		
		
		
	}
	
	public void removeUser(ArrayList<User> newUserlist)
	{
		
	}
	
	public static void main(String[] args)
	{
//		FileUserDAO dao = new FileUserDAO();
//		ArrayList<User> u = dao.LoadUsers();
//		System.out.println(u.size());
	}
}

