public class Quick {

    private final static int CUTOFF = 4;

    public static void sort(Comparable<Object>[] a) {
        Shuffle.shuffle(a); // 1 - Shuffle the array (Picked Knuth algorithm)
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable<Object>[] a, int lo, int hi) {
        if (hi <= lo + CUTOFF - 1)
        {
            Insertion.sort(a, lo, hi);
            return;
        }
        int p = partition(a, lo, hi); // 2 - Apply the partition
        sort(a, lo, p-1); // 3 - Apply this sort to LEFT hand-side of the pivot
        sort(a, p+1, hi); // 3 - Apply this sort to RIGHT hand-side of the pivot
    }

    private static int partition(Comparable<Object>[] a, int lo, int hi) {
        int i = lo - 1, j = hi; // Set pointers where it helps to compare the objects
        // Pivot chosen as most left item.
        while (true) {
            while (less(a[++i], a[hi])) if (i == hi) break; // Find the items less than the pivot
            while (less(a[hi], a[--j])) if (j == lo) break; // Find the items bigger than the pivot
            if (i >= j) break;
            exchange(a, i, j); // Exchange the bigger and smaller items in the array
        }
        exchange(a, hi, i);
        return i;
    }

    private static boolean less(Comparable<Object> object, Comparable<Object> object2) {
        return object.compareTo(object2) < 0;
    }

    private static void exchange(Comparable<Object>[] a, int i, int j) {
        Comparable<Object> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
