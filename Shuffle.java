import java.util.Random;

public class Shuffle {

    public static void shuffle(Comparable<Object>[] a) {
        Random random = new Random();
        int r, i;
        for (i = a.length - 1; i > 1; i--) {
            r = random.nextInt(i+1);
            exchange(a, i, r);
        }
    }

    private static void exchange(Comparable<Object>[] a, int i, int j) {
        Comparable<Object> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
