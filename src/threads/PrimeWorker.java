package threads;

public class PrimeWorker implements Runnable {
    int startIndex, endIndex;
    int[] array;
    int result;

    public PrimeWorker(int startIndex, int endIndex, int[] array) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++)
            if (Utils.isPrime(array[i]))
                result++;
    }

    public int getResult() {
        return result;
    }
}
