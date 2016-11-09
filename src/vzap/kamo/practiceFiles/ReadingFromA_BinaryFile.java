package vzap.kamo.practiceFiles;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadingFromA_BinaryFile
{
	private String pathName;
	private FileInputStream fis;
	private DataInputStream dis;
	private int score,b;
	private double d;
	private char ch;
	private File file;
	
	public ReadingFromA_BinaryFile()
	{
		pathName = "C:\\javaInputOutputFiles\\testfile.bin";
		file = new File(pathName);
		try
		{
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	public void readFromA_BinaryFile() throws IOException 
	{
		try
		{
			score = dis.readInt();
			ch = dis.readChar();
			byte b = dis.readByte();
			d = dis.readDouble();
			
			System.out.println(score);
			System.out.println(ch);
			System.out.println(b);
			System.out.println(d);
		}
		catch(Exception ex)
		{
			
		}
		
		dis.close();
		fis.close();
	}
	
	public static void main(String[] args)
	{
		ReadingFromA_BinaryFile rdMe = new ReadingFromA_BinaryFile();
		try
		{
			rdMe.readFromA_BinaryFile();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
