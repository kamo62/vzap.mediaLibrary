package vzap.kamo.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vzap.kamo.media.Catalogue;
import vzap.kamo.media.Login;

public class CatalogueTest
{
	private Login login;
	private String incomingPassword,incomingName;
	private Catalogue catalogue;
	
	@Before
	public void setUp() throws Exception
	{
		login = new Login();
		incomingPassword = "moo";
		incomingName = "kamom";
		catalogue = new Catalogue(incomingName);
	}

	@Test
	public void testSearchForUser()
	{
		assertNotNull(catalogue);
	}

}
