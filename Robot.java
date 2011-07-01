/**
 *
 * @author Leandro Henrique Mendes
 */
import java.net.*;
import java.io.*;

public class Robot {

    //Pega o codigo de alguma página web
    public static InputStream getXML(String path) throws Exception {
        String buffer = "";
        URL url = new URL(path);
        URLConnection uconn = url.openConnection();
        InputStream in = uconn.getInputStream();
        return in;
    }
    
}
