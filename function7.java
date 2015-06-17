import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Mian {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			getPerson(readFile("C:\\Users\\Administrator\\Desktop\\test.txt"),"33333333333");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
private static String getPerson(Map<String, String> map,String num) {
	 java.util.Iterator<Entry<String, String>> it = map.entrySet().iterator();
	   while (it.hasNext()) {
	    Map.Entry entry = (Map.Entry) it.next();
	    Object key = entry.getKey();
	    if (key.toString().equals(num)) {
	    	Object value = entry.getValue();
	    	 System.out.println("信息："+value+":"+key);
		}
	   }
	return null;
}

	private static Map<String, String> readFile(String filePath) throws IOException {
		FileInputStream fis;
		try {
			HashMap<String, String> hashMap=new HashMap<>();
			String line="";
			fis = new FileInputStream(filePath);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
			 String PhoneNum=line.substring(0,line.indexOf(" "));
			 String name=line.substring(PhoneNum.length()+1,line.length());
			 hashMap.put(name, PhoneNum);//参数一为电话号码。二文名字
			}
			return hashMap;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
