package pair2;

public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays =
                {
                        localDate.of(1906, 12, 9)
                }
    }
}
class ArrayAlg {
    public static <T extends Comparable> Pair<T> minmax(T[] a)
    {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }
}