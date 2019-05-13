package other;

import java.util.Random;

public class Sort {
    /**
     * Main function to test.
     * @param args      Console arguments
     */
    public static void main(String[] args) {
        int[] arr = {3,911,2,112,31};
        quickSort(arr, 0, arr.length - 1);
        for (Integer eachInt : arr) {
            System.out.println(eachInt);
        }
    }

    // =================================================================================================================
    /**
     * O(n^2) Selection sort.
     * @param sortContent           The integer array to be sorted.
     */
    // As if sorting a hand of poker cards, look one by one, and select the smallest card to be the first by swapping.
    public static void selectionSort(int[] sortContent)
    {
        int contentSize = sortContent.length;
        int minIndex = 0;

        // 0 to n - 2, and inner 0 to n - 1.
        // (n - 1) operations.
        for (int i = 0; i < contentSize - 1; i++) {
            minIndex = i;
            // n (n - 1) / 2
            for (int j = i + 1; j < contentSize; j++) {
                if (sortContent[j] < sortContent[minIndex])
                {
                    minIndex = j;
                }
            }

            int temp = sortContent[i];
            sortContent[i] = sortContent[minIndex];
            sortContent[minIndex] = temp;
        }
    }

    // =================================================================================================================
    /**
     * O(n^2) Bubble sort. O(N) Best case.
     * @param sortContent           The integer array to be sorted.
     */
    // Keep swapping until largest elements reach the end of array, bubble up to the end.
    public static void bubbleSort(int[] sortContent) {
        int contentSize = sortContent.length;
        boolean swap = false;
        // (n - 1) operations
        for (int i = 0; i < contentSize - 1; i ++) {
            // The end of array after each pass will contain the ith largest number.
            // (n - i - 1) operations.
            for (int j = 0; j < contentSize - i - 1; j++) {

                if (sortContent[j] > sortContent[j + 1])
                {
                    int temp = sortContent[j];
                    sortContent[j] = sortContent[j + 1];
                    sortContent[j + 1] = temp;
                    swap = true;
                }
            }
            // If no swap happened during the inner loop, the array is sorted.
            if (swap == false)
            {
                break;
            }
        }
    }

    // =================================================================================================================
    /**
     * O(n^2) Insertion sort. O(N) Best case.
     * @param sortContent           The integer array to be sorted.
     */
    // Keep array divided into sort and unsorted, always find a sorted position to insert the newly checked item.
    // Again, similar to organize poker cards.
    public static void insertionSort(int[] sortContent) {

        int contentSize = sortContent.length;

        // Assume first half before ith index is always sorted.
        // n operations
        for (int i = 1; i < sortContent.length; i++) {
            // Start checking item at second position.
            int insertValue = sortContent[i];
            int insertPosition = i;

            // Check where to position the insertValue;
            // Shifting items backwards.
            // n operations if not sorted.
            while (insertPosition > 0 && sortContent[insertPosition - 1] > insertValue) {
                sortContent[insertPosition] = sortContent[insertPosition - 1];
                insertPosition--;
            }

            // Do the insert.
            sortContent[insertPosition] = insertValue;
        }
    }

    // =================================================================================================================
    /**
     * O(n log n) Merge sort.
     * O(n) Space complexity.
     * @param sortContent           The array holding the content to be sorted.
     */
    // Divide and conquer method.
    public static void mergeSort(int[] sortContent)
    {
        int contentSize = sortContent.length;
        if (contentSize < 2)
        {
            return;
        }
        int middle = contentSize/2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[contentSize - middle];

        for (int i = 0; i < middle; i++) {
            leftArr[i] = sortContent[i];
        }

        for (int j = middle; j < contentSize; j++) {
            rightArr[j - middle] = sortContent[j];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, sortContent);
    }

    /**
     * O(n) Merge helper function.
     * @param leftContent           The left array to be merged.
     * @param rightContent          The right array to be merged
     * @param sortContent           The array that holds the merged result.
     */
    public static void merge(int[] leftContent, int[] rightContent, int[] sortContent) {
        int leftIdx = 0, rightIdx = 0, sortContentIdx = 0;

        // We look at the left and right, and select the smaller item to be put into the result array.
        while (leftIdx < leftContent.length && rightIdx < rightContent.length) {

            if (leftContent[leftIdx] < rightContent[rightIdx])
            {
                sortContent[sortContentIdx] = leftContent[leftIdx];
                leftIdx++;
            }
            else
            {
                sortContent[sortContentIdx] = rightContent[rightIdx];
                rightIdx++;
            }

            sortContentIdx++;
        }
        // There will be an array that got exhausted first,
        // and we need to fill the rest of sort content with elements remaining in the other array.
        while (leftIdx < leftContent.length) {
            sortContent[sortContentIdx] = leftContent[leftIdx];
            leftIdx++;
            sortContentIdx++;
        }

        while (rightIdx < rightContent.length) {
            sortContent[sortContentIdx] = rightContent[rightIdx];
            rightIdx++;
            sortContentIdx++;
        }

        return;
    }

    // =================================================================================================================

    /**
     * O(n log n) Quick sort. Worst case (n^2).
     * Worst case:
     * 1) Array is already sorted in same order.
     * 2) Array is already sorted in reverse order.
     * 3) All elements are same (special case of case 1 and 2)
     * @param sortContent           The integer array to be sorted.
     * @param low                   The lowest index of the sort content.
     * @param high                  The highest index of the sort content.
     */
    // Partition the array using a pivot, <= pivot to the left, > pivot to the right.
    public static void quickSort(int[] sortContent, int low, int high) {
        if (low < high)
        {
            int pivot = randomizePartition(sortContent, low, high);
            quickSort(sortContent, low, pivot - 1);
            quickSort(sortContent, pivot + 1, high);
        }
    }

    /**
     * O(n) Partition helper function.
     * @param sortContent           The integer array to be sorted.
     * @param low                   The lowest index of the sort content.
     * @param high                  The highest index of the sort content.
     * @return                      The pivot index position.
     */
    public static int partition(int[] sortContent, int low, int high) {
        // Determine pivot value.
        int pivotValue = sortContent[high];
        int pivotIdx = low;

        // We need to find the pivot index position.
        // Having to cursors, one keeps track of the pivot index, one iterates the array to partition the array.
        // If we find an element that should go before the pivot, we do the swap, and increment pivotIdx.
        // If not, we simply increment the iterator Idx.
        for (int i = low; i < high; i++) {
            // Swap values smaller or equal to pivot to the left of pivot.
            if (sortContent[i] <= pivotValue)
            {
                int temp = sortContent[i];
                sortContent[i] = sortContent[pivotIdx];
                sortContent[pivotIdx] = temp;
                pivotIdx++;
            }
        }

        // After find the pivot index, we can swap the value in.
        int temp = sortContent[high];
        sortContent[high] = sortContent[pivotIdx];
        sortContent[pivotIdx] = temp;

        return pivotIdx;
    }

    /**
     * Randomized partition to avoid worst case.
     * @param sortContent           The integer array to be sorted.
     * @param low                   The lowest index of the sort content.
     * @param high                  The highest index of the sort content.
     * @return                      The pivot index position.
     */
    public static int randomizePartition(int[] sortContent, int low, int high) {
//        // Picks a random number [low, high).
//        Random r = new Random();
//        int pivotIdx = r.nextInt((high - low) + 1) + low;;

        // Math.random() generates [0,1)
        int pivotIdx = low + (int) Math.random() * (high - low + 1);

        int temp = sortContent[high];
        sortContent[high] = sortContent[pivotIdx];
        sortContent[pivotIdx] = temp;

        return partition(sortContent, low, high);
    }
}
