import java.util.Scanner;

public class PyramidDrawer {
	
	public static void main(String arr[]) {
		Scanner input=new Scanner(System.in);
		
		System.out.println("Please enter the height of the pyramid: ");
		int height=input.nextInt();
		
		for(int i=1;i<=height;i++) {
			for(int j=1;j<=height-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.print("\n");
			
		}
		
		
		
		
	}
}
