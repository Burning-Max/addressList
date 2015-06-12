import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class O2F{
	public static void main(String[] args) {
		File f = new File(args[0]);
		ObjectOutputStream oos = null;

		Person p = new Person();

		try{
			oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(p);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}

class Person implements Serializable{
	String name = "Tom";
	transient int age = 20;
	boolean sex = true;
}