package string;

public class ReverseString {

    /**
     * Main function to test.
     * @param args      Console arguments
     */
    public static void main(String[] args) {
        char[] test = {'a', 'v', 'x'};
        reverseString(test);
        for (Character c : test)
        {
            System.out.print(c );
        }
    }

    /**
     * Reverse characters in a char array.
     * @param s         Char array that holds the characters.
     */
    public static void reverseString(char[] s) {
        int begin = 0, end = s.length - 1;
        char temp;
        while (begin < end)
        {
            temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
    }
}
