package other;

public class BinarySearch {
    /**
     * Main function to test.
     * @param args      Console arguments
     */
    public static void main(String[] args) {
        int[] searchContent = {1, 100, 101, 222, 321};
        System.out.println(binarySearch(searchContent, 1));
        System.out.println(recursiveBinarySearch(searchContent, 1, 0, 4));
    }

    // Must be sorted.
    /**
     * Function for binary search.
     * @param searchContent         Integer array containing the search content.
     * @param target                Target to find the index for.
     * @return                      The index of the target.
     */
    public static int binarySearch(int[] searchContent, int target) {

        int low = 0, high = searchContent.length - 1;
        int middle, possibleTarget;

        while (low <= high)
        {
            middle = (low + high) / 2;
            possibleTarget = searchContent[middle];

            if (possibleTarget == target)
            {
                return middle;
            }
            else if (possibleTarget < target)
            {
                low = middle + 1;
            }
            else if (possibleTarget > target)
            {
                high = middle - 1;
            }

        }

        return -1;
    }

    /**
     * Function for recursive binary search.
     * @param searchContent         Integer array containing the search content.
     * @param target                Target to find the index for.
     * @param low                   The minimal index for the search range.
     * @param high                  The maximum index for the search range.
     * @return                      The index of the target.
     */
    public static int recursiveBinarySearch(int[] searchContent, int target, int low, int high) {

        if (high < low)
        {
            return -1;
        }

        int middle = (low + high) / 2;
        int possibleTarget = searchContent[middle];

        if (possibleTarget == target)
        {
            return middle;
        }
        else if (possibleTarget < target)
        {
            return recursiveBinarySearch(searchContent, target, middle + 1, high);
        }
        else if (possibleTarget > target)
        {
            return recursiveBinarySearch(searchContent, target, low, middle - 1);
        }

        return -1;
    }
}
