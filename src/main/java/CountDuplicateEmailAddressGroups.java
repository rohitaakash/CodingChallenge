import java.util.HashMap;
import java.util.Map;

public class CountDuplicateEmailAddressGroups {

    public static void main(String[] args) {
        String[] emailAddress = {"a.b@example.com", "x@example.com", "x@exa.mple.com", "ab+1@example.com", "y@example.com", "y@example.com", "y@example.com"};
        System.out.println(countDuplicateGroups(emailAddress));
    }

    public static int countDuplicateGroups(String[] arr) {

        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (String anArr : arr) {
            String[] names = anArr.split("@");
            String localName = findLocalName(names[0]);
            if (map.containsKey(names[1])) {
                Map<String, Integer> localNames = map.get(names[1]);
                if (localNames.containsKey(localName)) {
                    localNames.put(localName, localNames.get(localName) + 1);
                } else {
                    localNames.put(localName, 1);
                }
            } else {
                Map<String, Integer> localNames = new HashMap<>();
                localNames.put(localName, 1);
                map.put(names[1], localNames);
            }
        }
        int countGroups = 0;

        for (String domainKey : map.keySet()) {
            Map<String, Integer> localNames = map.get(domainKey);
            for (String localName : map.get(domainKey).keySet()) {
                if (localNames.get(localName) > 1)
                    countGroups++;
            }
        }

        return countGroups;
    }

    private static String findLocalName(String str) {
        StringBuilder sb = new StringBuilder();
        String getValid = str.split("\\+")[0];
        String[] splitValid = getValid.split("\\.");
        for (String aSplitValid : splitValid) {
            sb.append(aSplitValid);
        }
        return sb.toString();
    }
}
