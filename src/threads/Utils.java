package threads;

import java.util.Random;

public class Utils {
    public static boolean isPrime(int n)
    {
        if (n < 2)
            return false;
        if (n == 2)
            return true;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n%i == 0)
                return false;
        return true;
    }

    public static int[] generateArray(int length)
    {
        Random rand = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++)
        {
            result[i] = rand.nextInt(1000);
        }
        return result;
    }
}
