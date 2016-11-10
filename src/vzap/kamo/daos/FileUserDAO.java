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
	ObjectOutputStream oos;
	ObjectInputStream ois;
	FileInputStream fis;
	FileOutputStream fos;
	
	public FileUserDAO() 
	{
		users = new ArrayList<User>();
		this.path = "./resources/users.bin";
		file = new File(path);
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
				users.add(new User("admin", "admin", "admin", "admin", true));
				this.saveUsers(users);
				System.out.println("Please use username: admin and password: admin");
			} 
			catch (IOException | Person_Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<User> LoadUsers()
	{
		try
		{
			//File listfile = new File("./resources/users.bin"); 
			FileInputStream fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			//Running through list
			System.out.println("Running through object list");
			ArrayList<User> users;
			users = (ArrayList<User>)ois.readObject();
			System.out.println("users size = " + users.size());
			ois.close();
			fis.close();
			return users;
			
		} 
		catch (Exception e)
		{
			System.out.println("An issue occured");
		}
		
		return null;
		
		
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
	
	public boolean saveUsers(ArrayList<User> user)
	{
		try
		{
			file = new File("./resources/users.bin");
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(user);
			oos.close();
			fos.close();
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
	
//	public static void main(String[] args)
//	{
//		FileUserDAO dao = new FileUserDAO();
//		
//		ArrayList<User> u = dao.LoadUsers();
//		System.out.println("u size = " + u.size());
//		if(u.size() < 2)
//		{
//			System.out.println("No items in file");
//			return;
//		}
//		dao.SaveUsers(u);
//	}
}

