
import java.util.Scanner; 
import java.io.IOException;
import java.io.FileWriter;

public class Funtion4+ {
	//private static final String LINE_SEPARATOR = System.getProperty("line.separtor"); 
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		String name ;
		String phone;
		System.out.printf("请输入联系人姓名和电话\n");
	    name =in.nextLine();
		phone = in.nextLine();
		in.close();
		System.out.print(name+"  "+phone);
		FileWriter fw = new FileWriter("linkman.txt",true);
		fw.write("联系人： "+name+"  "+"电话： "+phone+"\r\n");
		fw.flush();
		fw.close();
	}	
}

