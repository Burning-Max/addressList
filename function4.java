/*
 * �����ϵ��: ��ʾ�û����������Ϣ��¼�뵽��ϵ�ˣ���ӵ�linkman.txt�ļ���*/

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class Java1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name;
		String phone;
		System.out.printf("��������ϵ�������͵绰\n");
		name = in.nextLine();
		phone = in.nextLine();
		in.close();
		System.out.print(name + "  " + phone);
		FileWriter fw = null;
		try {
			fw = new FileWriter("D:\\linkman.txt", true);// �½����ļ����Զ����棬��ϵ����Ϣ����������D����
			fw.write("��ϵ�ˣ� " + name + "  " + "�绰�� " + phone + "\r\n");
			fw.flush();

		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("�ײ����");
				}
			}
		}
	}
}
