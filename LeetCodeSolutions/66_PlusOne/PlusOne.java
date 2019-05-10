package introToArray;

public class PlusOne {
    /**
     * Main function to test.
     * @param args      Console arguments
     */
    public static void main(String[] args) {
        int[] a = {9};
        int[] result = plusOne(a);

        for (int i : result){
            System.out.print(i + ",");
        }
    }

    /**
     * Function to add one to the integer array representing the integer.
     * @param digits        The integer array that represents the integer.
     * @return              The integer array with 1 added.
     */
    public static int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--)
        {
            digits[i]++;

            // If carry over needed.
            if (digits[i] > 9)
            {
                digits[i] = 0;
                carry = 1;
            }
            // Add one does not need to carry over, just return.
            else if (digits[i] <= 9)
            {
                return digits;
            }
        }

        // If we reach to the most significant digit and carry is still needed,
        // create a new array with one more spot for the carry over.
        int[] result = new int[digits.length + 1];
        for (int j = 0; j < result.length; j++)
        {
            if (j == 0)
            {
                result[j] = carry;
            }
            else
            {
                result[j] = digits[j-1];
            }
        }
        return result;
    }
}
