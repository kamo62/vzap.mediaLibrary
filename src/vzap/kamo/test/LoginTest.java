package vzap.kamo.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.UserException;

import vzap.kamo.exceptions.Person_Exception;
import vzap.kamo.media.Login;
import vzap.kamo.persons.User;

public class LoginTest
{
	private Login login;
	private String incomingPassword,incomingName;

	@Before
	public void setUp() throws Exception
	{
		login = new Login();
		incomingPassword = "moo";
		incomingName = "kamom";
	}

	@Test
	public void testVerify()
	{
		boolean verifiedUser = login.verify(incomingName,incomingPassword);
		assertTrue(verifiedUser);
	}
	
	@Test
	public void addUserTest() throws Person_Exception
	{
		User u = null;
		u = new User("Bob","Mabena","boob","1234",false);
		int cBefore,cAfter;
		cBefore = login.getUserCatalog().size();
		boolean a = login.addUser(u);
		cAfter = login.getUserCatalog().size();
		assertTrue(cAfter == (cBefore));

	}
	
	/* This is how you would test Exceptions to make sure they come back 
	   but you can't have the code in a try catch */
	@Test(expected = UserException.class) 
	public void addUserTest2() throws Person_Exception
	{
		User u = null;
		u = new User("","Mabena","boob","1234",false);
		int cBefore,cAfter;
		cBefore = login.getUserCatalog().size();
		boolean a = login.addUser(u);
	}

}
