import java.util.Scanner;

public class FuncSample {
	
	static int sum (int num1,int num2){
		int res_sum=num1+num2;
		return res_sum;
	}
	
	public static void main(String arr[]) {
		
		Scanner num=new Scanner(System.in);
		System.out.println("PLease enter 2 numbers: ");
		int number1=num.nextInt();
		int number2=num.nextInt();
		int result=sum(number1,number2);
		System.out.println("The result is "+result);
	}
	

}
