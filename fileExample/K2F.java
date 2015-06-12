import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class K2F{
    public static void main(String[] args) {
        File f = new File(args[0]);
        BufferedWriter bw = null;
        //FileWriter fw = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //InputStreamReader br = new InputStreamReader(System.in);

        int ch;
        try{
            bw = new BufferedWriter(new FileWriter(f));
            while((ch = br.read()) != '$'){
                bw.write(ch);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}