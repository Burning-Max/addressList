
import java.util.Scanner; 
import java.io.IOException;
import java.io.FileWriter;

public class Funtion4+ {
	//private static final String LINE_SEPARATOR = System.getProperty("line.separtor"); 
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		String name ;
		String phone;
		System.out.printf("��������ϵ�������͵绰\n");
	    name =in.nextLine();
		phone = in.nextLine();
		in.close();
		System.out.print(name+"  "+phone);
		FileWriter fw = new FileWriter("linkman.txt",true);
		fw.write("��ϵ�ˣ� "+name+"  "+"�绰�� "+phone+"\r\n");
		fw.flush();
		fw.close();
	}	
}

