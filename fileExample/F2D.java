import java.io.File;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;

public class F2D{
    public static void main(String[] args) {
        File f = new File(args[0]);
        DataInputStream dis = null;

        int ch;
        try{
            dis = new DataInputStream(new FileInputStream(f));
            while(true){
                ch = dis.readInt();
                System.out.println(ch);
            }
        }catch(EOFException e){

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                dis.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}