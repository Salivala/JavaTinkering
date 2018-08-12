import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Driver {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        try(InputStream fileStream = Files.newInputStream(Paths.get("./src", "test.xml"))) {
            Document doc = builder.parse(fileStream);
            Element root = doc.getDocumentElement();
            NodeList children  = root.getChildNodes();
            for (int i = 0 ; i < children.getLength(); i++ ) {
                if (children.item(i) instanceof Element) {
                    Text insideText = (Text) children.item(i).getFirstChild();
                    System.out.println(
                            ((Element) children.item(i)).getTagName() +
                                    ":" +
                                    insideText.getData().trim());
                }
            }
        }
    }

    public static int ack(int m, int n) {
        int ans;
        if (m == 0) ans = n + 1;
        else if (n == 0) ans = ack (m - 1, 1);
        else ans = ack(m - 1, ack(m, n - 1));
        return ans;
    }
    public static void go() {
        for (int i = 0; i < 100; i++) {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("./src", String.valueOf(i)), StandardOpenOption.CREATE)) {
                writer.write(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void no() {
        for (int i = 0; i < 100; i++) {
            try {
                Files.delete(Paths.get("./src", String.valueOf(i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
