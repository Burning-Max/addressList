/*
 * 添加联系人: 提示用户输入相关信息并录入到联系人，添加到linkman.txt文件。*/

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class Java1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name;
		String phone;
		System.out.printf("请输入联系人姓名和电话\n");
		name = in.nextLine();
		phone = in.nextLine();
		in.close();
		System.out.print(name + "  " + phone);
		FileWriter fw = null;
		try {
			fw = new FileWriter("D:\\linkman.txt", true);// 新建的文件，自动保存，联系人信息保存在里面D盘下
			fw.write("联系人： " + name + "  " + "电话： " + phone + "\r\n");
			fw.flush();

		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("底层错误");
				}
			}
		}
	}
}
