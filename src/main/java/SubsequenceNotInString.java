import java.util.*;

public class SubsequenceNotInString {

    public static void main(String[] args) {
        String s="a lot programming programming programming programming yo";
        String t = "programming programming";
        System.out.println(missingWords(s, t));
    }

    private static List<String> missingWords(String s, String t) {
        List<String> result = new ArrayList<>();
        String[] splitS = s.split(" ");
        Map<String, Set<Integer>> smap = new HashMap<>();
        for (int i=0; i<splitS.length; i++) {
            if(smap.containsKey(splitS[i])) {
                smap.get(splitS[i]).add(i);
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(i);
                smap.put(splitS[i], set);
            }
        }

        String[] splitT = t.split(" ");
        int prev = -1;
        for(int i=0; i<splitT.length; i++) {
            Set<Integer> set = smap.get(splitT[i]);
            if(prev != -1) {
                for(Integer index: set) {
                    if(index > prev) {
                        set.remove(index);
                        prev = index;
                        break;
                    }
                }
            }else{
                prev = set.iterator().next();
                set.remove(prev);
            }
        }

        for (int i=0; i<splitS.length; i++) {
            Set<Integer> set = smap.get(splitS[i]);
            if(!set.isEmpty()){
                int j = set.iterator().next();
                if(i == j) {
                    result.add(splitS[i]);
                    set.remove(j);
                }
            }

        }

        return result;
    }
}
