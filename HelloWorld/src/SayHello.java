import java.util.Scanner;

public class SayHello {
	
	public static void main(String ar[]) {
		
		Scanner s= new Scanner(System.in);
		
		System.out.println("PLease enter 2 numbers: ");
		
		int a=s.nextInt();
		int b=s.nextInt();
		int sum=a+b;
		
		System.out.println(a+"+"+b+"="+sum);
		
	}
	
	
	
	
}
