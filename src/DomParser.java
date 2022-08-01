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

    // Console font colors by https://stackoverflow.com/a/45444716
    public static final String RED = "\033[0;31m";
    public static final String YELLOW = "\033[0;33m";
    public static final String PURPLE = "\033[0;35m";
    public static final String RESET = "\033[0m";

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
            for(int n = 0; n < nodeList.getLength(); n++) {
                NamedNodeMap nodeMap = nodeList.item(n).getAttributes();

                System.out.println(YELLOW + nodeMap.getNamedItem("name").getNodeValue() + RESET + " = " + PURPLE + nodeMap.getNamedItem("value").getNodeValue());
                /*
                for(int o = 0; o < nodeMap.getLength(); o++) {
                    // NodeName = Name of the attribute o
                    // NodeValue or TextContent = value of the attribute o
                    if(nodeMap.item(o).getNodeName().equals("name")) {
                        System.out.println(nodeMap.item(o).getNodeValue() + "");
                    }
                }

                 */
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
