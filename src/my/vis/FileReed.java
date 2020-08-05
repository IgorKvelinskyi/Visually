
package my.vis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//класс для считывания файла
public class FileReed {    
    String part;    //путь где находится файл
    String s;
    public void Reed () throws FileNotFoundException, IOException{
    String filename = part;
        File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        //создаем стринговую переменную со всем текстом
        s = new String(data, "UTF-8");        
    }   
    
    
}
