import java.util.HashMap;

public class DictionaryTest {
	
	public DictionaryTest() {
		HashMap<String, String> test = new HashMap<>();
		
		test.put("sevenButton","7");
		test.put("eightButton","8");
		test.put("nineButton","9");
		test.put("tenButton","10");
		test.put("elevenButton","11");
		test.put("twelveButton","12");
		
		
		
		System.out.println(test.get("sevenButton"));
		
		
		
		
	}
	public static void main(String[] args) {
		DictionaryTest obj= new DictionaryTest();
		
	}

}
