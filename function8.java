//修改后的
import java.text.Collator;  
import java.util.Arrays;  
import java.util.Comparator;  
class function8 implements common
{
	public void open()
	{
		System.out.println("open");
		
	}
	public class test {  
    		public static void main(String[] args){ 
        	Comparator<Object> com=Collator.getInstance(java.util.Locale.CHINA);
		String[] nameArray={"张三 15676339280","李四 15638902749"};
        	Arrays.sort(nameArray,com);  
        	for(String i:nameArray){  
            		System.out.print(i+"  ");  
        	}  
    	}  
	public void close()
	{
		System.out.println("close");//提示信息
	}
}
