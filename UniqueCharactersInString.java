import java.util.HashSet;

/*
Is Unique: 
Implement an algorithm to determine if a string has all unique characters. 
>>>>>>>>>> What if you cannot use additional data structures?
*/
public class UniqueCharactersInString{
    public static void main(String[] args) {
        String word= "abcda";
        //Method-1(Brute Force)
        System.out.println(FindIfStringIsUniqueUsingBruteForce(word));
        //Method-2(Use Hash Map)
        System.out.println(FindIfStringIsUniqueUsingHashMap(word));
        //Method-3(With no additional Data Structure Usage)
        System.out.println(FindIfStringIsUniqueUsingIntegerBits(word));
    }
    //T.C =O(n) & S.C = O(1)
    private static boolean FindIfStringIsUniqueUsingIntegerBits(String word) {
        /*
        1) We know that an int has 4bytes in memory (4 bytes = 32 bits)
        2) we can use those bits to store 26 alphabets
        Ex: if string contains 'a' then int = ..00001
        */
        int storage=0;
        int ascii_value;
        for(int i=0;i<word.length();i++){
            ascii_value = (int)word.charAt(i)-97;
            if((storage&1<<ascii_value)==1){
                return false;
            }
            storage |= 1<<ascii_value;
        }        
        return true;
    }
    //T.C =O(n) & S.C = O(n)
    private static boolean FindIfStringIsUniqueUsingHashMap(String word) {
        HashSet<Character> hash = new HashSet<>();
        for(int i=0;i<word.length();i++){
            if(hash.contains(word.charAt(i)))//If our Hashset contains the word then it is occuring twice
                return false;
            hash.add(word.charAt(i));//Else we add it to our Hash for future reference
        }
        return true;
    }
    //T.C =O(n*n) & S.C = O(1)
    private static boolean FindIfStringIsUniqueUsingBruteForce(String word) {
        //Compare every letter in the String with the right side of the String.
        //In worst case TC = O(n*2)
        for(int i=0;i<word.length()-1;i++){
            char letter = word.charAt(i);
            //Now start searching in the ri8 hand side
            for(int j=i+1;j<word.length();j++){
                if(letter == word.charAt(j))
                    return false;//We dont have to search the remaining lot
            }
        }
        return true;//All comparisions are made and we did not find any match, hence return's true
    }
}