package  com.lovo.addressBook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
public class Login {
	/**
	 * 构造方法
	 */
	public  Login() {
		//加载用户口令文件
		Properties propAdmin = new Properties();	
		try{
			propAdmin.load(new FileInputStream("config/admin.properties"));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		int i=3;//输入用户名三次为限
		String inputName=null;//输入的用户名
		boolean checked = false;//若口令正确,校验通过:checked = true
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(i > 0){
			    //输错三次用户名,退出循环
			    //用户名正确,但输错三次口令,退出循环
			    //用户名正确,口令正确,校验通过,退出循环
			    if(checked){
					break;
				 }
			    System.out.print("\n请输入用户名:");
		        try {
					inputName = bf.readLine().trim();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//如果用户名正确,则输入口令
				if(inputName.equals(propAdmin.getProperty(inputName+".name"))){
					int j=3;//输入口令三次为限
					String inputPwd = null;//输入的口令
					while(true){
						 if(j == 0){//输错三次口令
							i=0;//设i为0,使上层循环终止
							break;
						 }
					     System.out.print("\n请输入口令:");
					     try {
							inputPwd = bf.readLine().trim();
						 } catch (IOException e) {
							e.printStackTrace();
						 }
						if(inputPwd.equals(propAdmin.getProperty(inputName+".password")))
							{
								checked = true;//校验通过
								break;
							}else{
								System.out.print("口令不正确");	
							    j--;
						   }
					}
				}else{
					System.out.print("该用户不存在");	
					i--;
				}
	    }	
		//校验通过
		if(checked){
			new MainUI();
		}
		
	}
}