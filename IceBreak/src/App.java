import java.util.Scanner;

public class App {

    


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int array[];

        System.out.println("PLease enter the array size: ");
        int arraySize= input.nextInt();
        for(int i=0;i<arraySize;++I){
            System.out.println("number-"+i+1+": ");
            array[i]=input.nextInt();
        }

        System.out.println("Array is :");
        for(int i=0;i<arraySize;++I){
            System.out.println("number-"+i+1+": "+array[i]);
            
        }
    
    }
}
