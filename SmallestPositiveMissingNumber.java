import java.util.Arrays;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        int[] array = {36, 20 ,44 ,-5, 8 ,2, -42, 36, 48, -45 ,-37, -6, -20 ,-29 ,-3, -43 ,8, -50, 28, -21, -43 ,8, 3 ,29, -43, 22 ,25 ,-40 ,-48 ,-46 ,-42 ,-10,
            -24, -48, 36, 35 ,-44, -4, -27, -46 ,1, -13, -49, -17, -40, -2, 42};
        int min=1;
        System.out.println(Arrays.toString(array));
        boolean min_is_set = false;
        for(int i=0;i<array.length;i++){
            if(array[i]>0){
                if(!min_is_set){
                    if(array[i]==1) min=array[i];
                    else min = array[i]-1;
                    min_is_set =true;System.out.println("I am set now as "+min);
                }
                else if(array[i]<min && min!=1){
                     min = array[i]-1;System.out.println("Element "+array[i]+" Found at: "+i+" min is: "+min);
                }
            }
        }
        System.out.println(min);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}