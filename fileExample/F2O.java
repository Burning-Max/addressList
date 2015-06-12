import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class F2O{
	public static void main(String[] args) {
		File f = new File(args[0]);
		ObjectInputStream ois = null;

		Person p;

		try{
			ois = new ObjectInputStream(new FileInputStream(f));
			p = (Person)ois.readObject();
			System.out.println(p.name);
			System.out.println(p.age);
			System.out.println(p.sex);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

	}
}

class Person implements Serializable{
	String name = "Tom";
	transient int age = 20;
	boolean sex = true;
}