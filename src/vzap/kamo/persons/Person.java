package vzap.kamo.persons;

import vzap.kamo.exceptions.Person_Exception;

public abstract class Person
{
	private String name;
	private String surname;

	public Person(String name, String surname) throws Person_Exception
	{
		this.name = name;
		this.surname = surname;
		if(this.name.isEmpty() || this.name.equals("") || this.surname.isEmpty() || this.surname.equals(""))
		{
			throw new Person_Exception("You need to enter both name and Surname");
		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	@Override
	public String toString()
	{
		return "Person [name=" + name + ", surname=" + surname + "]";
	}

}
