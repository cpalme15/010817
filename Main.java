import java.io.*;
import java.util.*;

public class Main {
public static void main(String [] args)
/*convert from decimal to binary
*/
	{  Scanner k1=null;	//reading text files
		PrintWriter pw=null;// writing to text files
		FileOutputStream fos=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;//writing to binary files
		ObjectOutputStream oos=null;//reading from binary files
		File f=null;
		Random r=new Random();
		Customer c1=new Customer("John Doe",46,598.56);
		Customer child=new Customer();
		f=new File("mycustomer.dat");
		if(f.exists())//checks to see if the file exists
			System.out.println("file exits, are you sure you want to overrte it");
		else
			System.out.println("dont exist");
		try {
			oos=new ObjectOutputStream(new FileOutputStream("mycustomers.dat"));
			oos.writeObject(c1);
			for(int i=1;i<=10;i++){
				oos.writeInt(r.nextInt(100));
			}
			oos.close();
			ois=new ObjectInputStream(new FileInputStream("mycustomers.dat"));
			try {
				child=(Customer) ois.readObject();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("his balance is: "+child.getBalance());
			while(ois.available()>0)//if there is more bytes than zero to read
			{
				System.out.println(ois.readInt());
			}
			ois.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			fos=new FileOutputStream("mynumbers.txt");
			pw=new PrintWriter(fos);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		pw.println(56);
		pw.println(49);
		pw.close();
		try {
			fis=new FileInputStream("grades.txt");
			k1=new Scanner(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	while(k1.hasNext())
	{
		System.out.println(k1.nextInt());
	}
	k1.close();
		/*
		 * two types of files
		 * 1. text
		 * 2. binary
		 * 
		 * creating files either
		 * 1.computer generated
		 * 2. user creates file
		 */
	}
}
