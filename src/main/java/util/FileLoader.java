package util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileLoader {
    public static FileReader load(String fileName){
        FileReader fileRead = null;
        try{
            fileRead = new FileReader(fileName);
        }catch(IOException e){
            System.out.println(e);
        }
        return fileRead;
    }
}
