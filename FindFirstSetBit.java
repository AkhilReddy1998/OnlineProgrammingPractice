public class FindFirstSetBit{
    public static void main(String[] args) {
        //In binary representation get the 1st occurence of bit "1" from the right hand side
        //Ex: 4 == 0010
        //So 1st occurence of bit "1" is at 2nd position
        int number = 0;
        int temp = number;int counter=1;
        //methodOne(number);
        //Method two use Logical operators
        while(temp!=0){
            if( (temp &1) == 1) break;
            else temp >>=1;
            counter++;
        }
        System.out.println("Found at position: "+counter);
    }
    private static void methodOne(int number) {//COnvert to Binary chunks
        if(number!=0){
            System.out.println(number%2);
            if(number%2 == 1)
                System.out.println("found first occurence");
            methodOne(number/2);
        }
    }
}