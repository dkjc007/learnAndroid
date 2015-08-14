import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class TestWriteXML {

	public static void main(String[] args) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		Element leaf = root.addElement("leaf");
		Element author1 = leaf.addElement("author")
				.addAttribute("name", "jiangchao")
				.addAttribute("age", "25");
		Element author2 = leaf.addElement("author")
				.addAttribute("name", "dkjc")
				.addAttribute("age", "25");
		Element author3 = leaf.addElement("author")
				.addAttribute("name", "jc")
				.addAttribute("age", "25");
		Element job = root.addElement("job").addText("sz");
		
		System.out.println(document.asXML());
	}

}
