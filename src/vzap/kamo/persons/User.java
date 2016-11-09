package vzap.kamo.persons;

import vzap.kamo.exceptions.Person_Exception;

public class User extends Person
{

	private String username;
	private String password;
	private boolean isAdmin;

	public User(String name, String surname, String username, String password, boolean isAdmin) throws Person_Exception
	{
		super(name, surname);
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		if(this.username.isEmpty() || this.username.equals(""))
		{
			throw new Person_Exception("Username is blank");
		}
	}

	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin()
	{
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}


	

}
