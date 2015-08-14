import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class TestCreateJson {
	public static void main(String[] args) {
		JsonObject object = new JsonObject();
		object.addProperty("name", "jiangchao");
		
		JsonArray array = new JsonArray();
		JsonObject like1 = new JsonObject();
		like1.addProperty("name", "cat");
		like1.addProperty("age", 14);
		array.add(like1);
		
		JsonObject like2 = new JsonObject();
		like2.addProperty("name", "dog");
		like2.addProperty("age", 18);
		array.add(like2);
		
		JsonObject like3 = new JsonObject();
		like3.addProperty("name", "uu");
		like3.addProperty("age", 14);
		array.add(like3);
		
		object.add("like", array);
		object.addProperty("age", 25);
		
		System.out.println(object.toString());
	}
}
