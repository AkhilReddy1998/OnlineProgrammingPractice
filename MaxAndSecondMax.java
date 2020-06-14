import java.util.ArrayList;

public class MaxAndSecondMax {
    public static void main(String[] args) {
        //Find 1st & 2nd max in array
        ArrayList<Integer> temp = new ArrayList<>();
        /*array.add(5);array.add(2);array.add(3);
        array.add(4);array.add(1);
        array.sort(null);*/
        int[] array = {2,2,2};
        int max1=Integer.MIN_VALUE+1,max2=max1-1;
        
        for(int i=1;i<array.length;i++){
            if(array[i]>max1){
                max2= max1;
                max1=array[i];
            }
            else if(array[i]!=max1){
                if(array[i]>max2)
                    max2 = array[i];
            }
        }
        System.out.println(max1+" "+max2);
    }
}