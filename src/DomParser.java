import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

public class DomParser {

    public static void parseXml(File xmlPath) {
        LinkedHashMap<String, String> output = new LinkedHashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


        try {
            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
//            factory.setFeature(LOAD_EXTERNAL_DTD_SETTING, false);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlPath);

            NodeList nodeList = doc.getElementsByTagName("Property");
            for (int n = 0; n < nodeList.getLength(); n++) {
                NamedNodeMap nodeMap = nodeList.item(n).getAttributes();
                System.out.println(Console.RESET + nodeMap.getNamedItem("name").getNodeValue() + " | " + Console.YELLOW + nodeMap.getNamedItem("value").getNodeValue() + Console.RESET + " | " + Console.CYAN + "2nd file attribute value");
                Console.nextEntry();
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    /*
    public File writeXmlFile() {

    }
    */
}
