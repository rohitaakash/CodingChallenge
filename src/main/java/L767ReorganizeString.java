import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L767ReorganizeString {
    public static void main(String[] args) {
        String input = "tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao";
        System.out.println(reorganizeString(input));
    }

    private static String reorganizeString(String S) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            } else {
                map.put(S.charAt(i), 1);
            }
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        Character prevKey = '#';
        map.put(prevKey, -1);

        while (!pq.isEmpty()) {
            Character letter = pq.poll();
            sb.append(letter);

            if (map.get(prevKey) > 0) {
                pq.add(prevKey);
            }

            prevKey = letter;
            map.put(prevKey, map.get(prevKey) - 1);
        }

        return (sb.toString().length() == S.length()) ? sb.toString() : "";
    }

}