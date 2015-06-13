/*通讯系统项目管理方案
	 1、用户注册: 按格式录入用户名和密码。保存在secret.txt文件中。
	    用户名与密码用’*’隔开，每组信息用’$’隔开，并为该用户建立一个文件
	 2、用户登录: 根据用户输入的账号密码，检测所有账号密码序列，若匹配则进入相应文件夹。 
	 3、用户注销: 根据用户输入和账号密码，找到相应的文件夹，并删除。
	 4、添加联系人: 提示用户输入相关信息并录入到联系人，添加到linkman.txt文件。
   	*5、删除联系人: 根据用户输入信息查找联系人并删除其信息。
	 6、查找联系人: 根据用户输入姓名查找联系人，输出手机号。
	 7、查找联系人: 根据用户输入手机号查找练习人。
	 8、显示全部联系人: 按姓名显示全部联系人。
	 9、将通讯录所有联系人生成txt文件。
	 10、显示帮助信息。
	 11、退出程序。
*/

/*
** Function5的功能:
**   删除联系人: 根据用户输入信息查找联系人并删除其信息。
**   步骤:
		1.接收用户字符
		2.字符匹配
		3.删除相应$~$之间信息
		4.保存并退出
		
** 数据结构:
**	  用户名  字符串                八位（多删少补，以下雷同）
	  密码	  字符串                八位
	  姓名	  字符串                八位
	  性别	  字符（’f’ or ’m’）一位
	  电话	  字符串                十一位
*/

/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
*/

import java.io*;

private class structUserDate implements Serializable(){
	
	UserNmae = new char[8];
	Password = new int[8];
	Name = new char[8];
	Sex = new char[1];
	Phone = new int[11];
	
}

//功能实现示例
class function5 implements common
{
	public void open()
	{
		Scanner sc = new Scanner(System.in); 
		System.out.println("请输入您想要删除的联系人的名字:");//提示信息
		String name = sc.nextLine(); 
        
		//接收用户字符 注意:next() 和 nextLine() 的区别 <--!next()在接收到有效数据前，所有的空格或者tab键等输入被忽略，若有有效数据，则遇到这些键退出--> 
		
		operateLinkManInfo.openLinkMan();//打开文件linkman.txt
		if(!operateLinkManInfo.deleteInfo(name, ois)){//文件操作:参照用户名<字符匹配>, 找到并删除, 关闭并退出
			System.out.println("操作失败!");
		}
		
	}
	public void close()
	{
		operateLinkManInfo.closeLinkMan();
	}
}

class operateLinkManInfo(){
	static {
		String filename = "linkman.txt"
	  //String filename = new String("linkman.txt");
	  //       filename = new String("linkman.txt");
	    
		File f = new File(filename);
	  
	}
	
	void openLinkMan(){
		
		ObjectInputStream ois = null;//对象,序列化  *未用到

		try{
			static ois = new ObjectInputStream(new FileInputStream(f));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	boolean deleteInfo(String name, ObjectInputStream file){
		
		/*
		 1.标记$的位置,字符匹配,
		 2.匹配成功,则返回标记位置,删除数据直到遇到$,否则继续.直到文件结束,返回提示
		 3.关闭文件.
		*/
		BufferedReader br = null; 
		String lineDelete = "UserNmae:"+name ;

		try {
			//构造BufferedReader对象
			br = new BufferedReader(new FileReader(f));

			String line = null;
			while ((line = br.readLine()) != null || (line = br.readLine()) == '$') {  //定位一个用户
				//开始匹配
				if( name == br.read(char[name.length()] cbuf)){  //找到,退出
					removeLineFromFile(filename, lineDelete, 5);
					return true;
				}else{  //未找到,继续
					continue;
				}
			}
			return false;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {

			//关闭BufferedReader
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	void closeLinkMan{
	
		ObjectOutputStream oos = null;

		try{
			oos = new ObjectOutputStream(new FileOutputStream(f));
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}

public void removeLineFromFile(String file, String lineToRemove, int num) {

	try {

	File inFile = new File(file);

		if (!inFile.isFile()) {
			System.out.println("Parameter is not an existing file");
			return;
		}

	//Construct the new file that will later be renamed to the original filename. 
	File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

	BufferedReader br = new BufferedReader(new FileReader(file));
	PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

	String line = null;

	//Read from the original file and write to the new 
	//unless content matches data to be removed.
	while ((line = br.readLine()) != null) {

		for (int i =1; (!line.trim().equals(lineToRemove)) || (!line.startsWith("$")); i <= num ) {
			
			pw.println(line);
			pw.flush();
		}
	}
	pw.close();
	br.close();

	//Delete the original file
	if (!inFile.delete()) {
		System.out.println("Could not delete file");
		return;
	} 

	//Rename the new file to the filename the original file had.
	if (!tempFile.renameTo(inFile))
		System.out.println("Could not rename file");

	}
	catch (FileNotFoundException ex) {
		ex.printStackTrace();
	}
	catch (IOException ex) {
		ex.printStackTrace();
	}
}