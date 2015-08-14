import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


public class TestReadJson {

	public static void main(String[] args) {
		try {
			JsonParser parser = new JsonParser();
			File file = new File("test.txt");
			JsonObject object = (JsonObject) parser.parse(new FileReader(file));
			System.out.println(object.toString());
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
