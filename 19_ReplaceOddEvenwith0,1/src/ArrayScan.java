import java.util.Scanner;

public class ArrayScan {
    int arraySize;
    int array[]= new int[arraySize];
    ArrayScan(){
        Scanner input = new Scanner(System.in);
        System.out.println("PLease enter the array size: ");
        int arraySize= input.nextInt();
        int array[]= new int[arraySize];
        for(int i=0;i<arraySize;i++){
            System.out.println("number-"+(i+1)+": ");
            array[i]=input.nextInt();
        }   
        this.array=array;    
        this.arraySize=arraySize;
        System.out.println("Given array is :");
        for(int i=0;i<array.length;++i){
            System.out.println("number-"+(i+1)+": "+array[i]);
        }
    }
}