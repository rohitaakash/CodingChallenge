public class L65CompareVersionNumbers {

    public static void main(String[] args) {
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("01", "1"));
        System.out.println(compareVersion("1.0", "1"));
    }

    private static int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) return 0;

        String[] split1 = version1.trim().split("\\.");
        String[] split2 = version2.trim().split("\\.");

        int i = 0, j = 0, num1, num2;
        while (i < split1.length || j < split2.length) {
            if (i < split1.length) num1 = parseInt(split1[i]);
            else num1 = 0;

            if (j < split2.length) num2 = parseInt(split2[j]);
            else num2 = 0;

            if (num1 > num2) return 1;
            else if (num1 < num2) return -1;
            else {
                i++;
                j++;
            }
        }

        return 0;
    }

    public static int parseInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
        }
        return num;
    }
}
