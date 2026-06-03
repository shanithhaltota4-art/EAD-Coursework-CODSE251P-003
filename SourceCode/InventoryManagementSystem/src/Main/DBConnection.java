
package Main;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DBConnection {
    
    static String username, password, host, port, DBName;
    
    public static Connection createConnection() throws Exception{
        
        File xmlFile = new File("src/XML/DB.xml");
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xmlFile);
        
        NodeList NLUser, NLPass, NLHost, NLPort, NLDBName;
        Element ELuser, ELPass, ELHost, ELPort, ELDBName;

        NLUser = doc.getElementsByTagName("user");
        ELuser = (Element) NLUser.item(0);
        username = ELuser.getChildNodes().item(0).getNodeValue().trim();

        NLPass = doc.getElementsByTagName("password");
        ELPass = (Element) NLPass.item(0);
        password = ELPass.getChildNodes().item(0).getNodeValue().trim();

        NLHost = doc.getElementsByTagName("host");
        ELHost = (Element) NLHost.item(0);
        host = ELHost.getChildNodes().item(0).getNodeValue().trim();

        NLPort = doc.getElementsByTagName("port");
        ELPort = (Element) NLPort.item(0);
        port = ELPort.getChildNodes().item(0).getNodeValue().trim();

        NLDBName = doc.getElementsByTagName("DB");
        ELDBName = (Element) NLDBName.item(0);
        DBName = ELDBName.getChildNodes().item(0).getNodeValue().trim();

        String url = "jdbc:mysql://" + host + ":" + port + "/" + DBName + "?autoReconnect=true&useSSL=false";
        Connection con = DriverManager.getConnection(url, username, password);
        
        return con;
        
    }
    
}
