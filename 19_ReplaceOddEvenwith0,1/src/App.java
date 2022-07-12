public class App {

   
    public static void OdEv01(int[] array){
        for(int i=0;i<array.length;i++){
            if (array[i]%2!=0){
                array[i]=0;
                continue;
            }
            if (array[i]%2==0){
                array[i]=1;
                continue;
            }
        }
        System.out.println("Binary array is :");
        for(int i=0;i<array.length;++i){
            System.out.println("number-"+(i+1)+": "+array[i]);
        }

    }

    public static void main(String[] args) throws Exception {
        
        ArrayScan obj=new ArrayScan();
        int arraySize=obj.arraySize;
        int[] arr= new int[arraySize];
        arr=obj.array;
        App.OdEv01(arr);
        
        
    } 
}

                                          

        

    