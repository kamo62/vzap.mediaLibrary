package vzap.kamo.practiceFiles;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class WritingBinaryFile
{
	private String pathName;
	private FileOutputStream fos;
	private DataOutputStream dos;
	private int score,b;
	private double d;
	private char ch;
	private File file;
	
	public WritingBinaryFile()
	{
		pathName = "C:\\javaInputOutputFiles\\testfile.bin";
		file = new File(pathName);
		
		try
		{
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			score = 10;
			ch = 'a';
			b = 15;
			d = 99.99;
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	public void writeToBinaryFile()
	{
		try
		{
			dos.writeInt(20);
			dos.writeChar('z');
			dos.writeByte(99);
			dos.writeDouble(d);
			
			System.out.println("File written succussfully");
			dos.close();
			fos.close();
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args)
	{
		WritingBinaryFile newWBF = new WritingBinaryFile();
		newWBF.writeToBinaryFile();
	}
}
