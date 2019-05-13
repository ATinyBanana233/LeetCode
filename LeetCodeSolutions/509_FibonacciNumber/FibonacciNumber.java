package other;

public class Fibonacci {
    /**
     * Main function to test.
     * @param args      Console arguments
     */
    public static void main(String[] args) {
        System.out.println(fibRecursive(8));
        System.out.println(fibIterative(8));
    }

    /**
     * Function to recursively calculate fibonacci number.
     * @param N         The nth fibonacci number.
     * @return          The nth fibonacci number.
     */
    public static int fibRecursive(int N) {
        // Check
        if (N < 0)
        {
            throw new IllegalArgumentException();
        }
        else if (N <= 1)
        {
            return N;
        }

        return fibRecursive(N - 2) + fibRecursive( N - 1);
    }

    /**
     * Function to iteratively calculate fibonacci number.
     * @param N         The nth fibonacci number.
     * @return          The nth fibonacci number.
     */
    public static int fibIterative(int N) {
        // Check
        if (N < 0)
        {
            throw new IllegalArgumentException();
        }

        if (N <= 1)
        {
            return N;
        }

        // Fibonacci number start with 0th as well, so when N = 3, we have 4 fibonacci numbers.
        // One more slot to hold 0th fibonacci number.
        int fib[] = new int[N + 1] ;
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= N; i++)
        {
            fib[i] = fib[i - 2] + fib[i - 1];
        }

        return fib[N];
    }
}
