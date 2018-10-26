import java.util.HashSet;
import java.util.Set;

public class L681NextClosestTime {

    public static void main(String[] args) {
        String time = "12:33";
        System.out.println(nextClosestTime(time));
    }

    private static String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != ':') {
                set.add(time.charAt(i) - '0');
            }
        }
        int original = Integer.parseInt(time.substring(0, 2)) * 60;
        original += Integer.parseInt(time.substring(3));

        int min = Integer.MAX_VALUE;
        for (int h1 : set) {
            for (int h2 : set) {
                if (h1 * 10 + h2 < 24) {
                    for (int m1 : set) {
                        for (int m2 : set) {
                            if (m1 * 10 + m2 < 60) {
                                int minutes = (h1 * 10 + h2) * 60 + m1 * 10 + m2;
                                if (minutes < min && minutes > original)
                                    min = minutes;
                            }
                        }
                    }
                }
            }
        }

        return String.format("%02d:%02d", min / 60, min % 60);
    }
}
