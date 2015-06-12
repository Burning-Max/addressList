import java.io.File;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class D2F{
    public static void main(String[] args) {
        File f = new File(args[0]);
        //FileOutputStream fos = null;
        DataOutputStream dos = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ch;
        String str = null;
        try{
            dos = new DataOutputStream(new FileOutputStream(f));
            while((str = br.readLine()) != null){
                ch = Integer.parseInt(str);
                dos.writeInt(ch);
            }
        }catch(IOException e){
            e.printStackTrace();
        }catch(NumberFormatException e){

        }finally{
            try{
                dos.close();
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}