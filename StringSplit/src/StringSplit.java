
public class StringSplit {
	
	public static void main(String arr[]) {

		String Work="R+D";
		String Workparts[]=Work.split("\\+");
		
		for (int i=0;i<Workparts.length;i++) {
			System.out.println("---->"+Workparts[i]);
		
		}
	}
}	
