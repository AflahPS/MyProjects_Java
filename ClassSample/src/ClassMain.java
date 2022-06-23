
public class ClassMain {

	public static void main(String a[]) {
		
		ClassSample hp= new ClassSample();
		ClassSample canon= new ClassSample();
		
		hp.r = 300;
		hp.d=200;
		canon.r=350;
		canon.d=250;
		
		System.out.println("Total for HP is: "+hp.total());
		System.out.println("Total for CANON is: "+canon.total());
	}
}
