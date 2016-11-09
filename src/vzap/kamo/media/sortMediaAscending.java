package vzap.kamo.media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import vzap.kamo.persons.User;

public class sortMediaAscending implements Comparator<Media>
{

	@Override
	public int compare(Media o1, Media o2)
	{
		return o2.getName().compareToIgnoreCase(o1.getName());
	}
	

}
