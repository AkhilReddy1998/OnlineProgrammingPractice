import java.util.*;
public class WaveNumbers {
    public static void main(String[] args) {
        int[] array = {2 ,4 ,7 ,8 ,9 ,10};
        /*
        Strategy-1: Sort the array, swap adjacent elements
        Arrays.sort(array);
        for(int i=0;i<array.length;i=i+2){
            System.out.println("i is: "+i);
            if(i+1<array.length){
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
        */
        //Strategy-2:
        //1)Traverse even index elements
        //-->If it is smaller than left element swap it
        //->>If it is smaller than right element swap it 
        for(int i=0;i<array.length;i+=2){
            if(i>1 && array[i]<array[i-1]){
                //Swap
                int temp = array[i];
                array[i] = array[i-1];
                array[i-1]=temp;
            }
            if(i+1<array.length && array[i]<array[i+1]){
                //Swap
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1]=temp;
            }            
        }
        System.out.println(Arrays.toString(array));
    }
}