import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {

        ///Does not work....................................................
        int[] array ={2 ,4, 6, 8 ,10 ,12 ,14 ,16 ,18 ,20};
        int len = array.length;
        int rotate = 2;
        int actual_rotate = len-rotate;
        for(int i=0;i<6;i++){
            int first = i;
            int swap_element = (i+actual_rotate)%len;
            //Swap element
            int temp = array[first];
            array[first] = array[swap_element];
            array[swap_element] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}