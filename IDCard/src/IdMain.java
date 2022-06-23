import java.util.Scanner;

public class IdMain {
	public static void main(String a[]) {
		Scanner input =new Scanner(System.in);
		IdClass[] students= new IdClass[3];
			
		for (int i=0;i<3;i++) {
			
			students[i]=new IdClass();
			
			System.out.println("Please enter student-"+(i+1)+" credentials ");
			
			System.out.println("NAME: ");
			String name=input.nextLine();
			
			System.out.println(" "+name);
		
			System.out.println("AGE: ");
			String age=input.nextLine();
			
			System.out.println(" "+age);
		
			System.out.println("PHONE: ");
			String phone=input.nextLine();
			
			System.out.println(" "+phone);
			
			students[i].name=name;
			students[i].age=age;
			students[i].phone=phone;
			
		}
			
			System.out.println("Student details are: \n");
			for (int j=0;j<3;j++) {
				students[j].displayID();
			}	
			
	
	}
}
