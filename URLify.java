public class URLify{
    public static void main(String[] args) {
        /*
        Write a method to replace all spaces in a string with '%20
        Ex: 
        Input:"Mr John Smith    "; (Given additional space)
        Output:"Mr%20John%20Smith" 
        */

		String str = "Mr John Smith    ";
		char[] arr = str.toCharArray();System.out.println("String length is: "+str.length());
		int trueLength = findLastCharacter(arr) + 1;System.out.println("true Length is : "+trueLength);
		replaceSpaces(arr, trueLength);	
		System.out.println(String.copyValueOf(arr));        
    }

	public static int findLastCharacter(char[] str) {

		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i;
			}
		}
		return -1;
    }    

	public static void replaceSpaces(char[] str, int trueLength) {

		int spaceCount = 0, index, i = 0;
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}System.out.println("Space count is: "+spaceCount);
		index = trueLength + spaceCount * 2;System.out.println("Index is : "+index);
		if (trueLength < str.length) str[trueLength] = '\0';
		for (i = trueLength - 1; i >= 0; i--) {System.out.println("char is: "+str[i]);
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}    
}