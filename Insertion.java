public class Insertion {
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            Comparable curr = a[i];
            int j = i - 1;
            while (j >= lo && curr.compareTo(a[j]) < 0) {
                exchange(a, j, j + 1);
                j--;
            }
        }
    }

    private static void exchange(Comparable<Object>[] a, int i, int j) {
        Comparable<Object> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}