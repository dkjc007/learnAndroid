import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;


public class TestReadXML {
	public static void main(String[] args) {
		try {
			File file = new File("text.xml");
			SAXReader reader = new SAXReader();
			Document document = reader.read(file);
			System.out.println(document.asXML());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
