import java.util.TreeSet;

public class L683KEmptySlots {

    public static void main(String[] args) {
        int[] flowers = {2, 5, 1, 4, 3};
        System.out.println(kEmptySlots(flowers, 2));
    }

    private static int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> blooming = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            blooming.add(flowers[i]);
            Integer lower = blooming.lower(flowers[i]);
            Integer higher = blooming.higher(flowers[i]);
            if ((lower != null && flowers[i] - lower - 1 == k) || (higher != null && higher - flowers[i] - 1 == k)) {
                return i + 1;
            }
        }
        return -1;
    }

}
