import java.util.*;

public class SocialNetwork {

    public static void main(String[] args) {
        List<Integer> counts = Arrays.asList(3, 3, 3, 3, 3, 1, 3);
        socialGraphs(counts);
    }

    private static void socialGraphs(List<Integer> counts) {
        Map<Integer, List<List<Integer>>> network = new TreeMap<>(Collections.reverseOrder());
        int i = 0;
        for (Integer num : counts) {
            if (network.containsKey(num)) {
                List<List<Integer>> list = network.get(num);
                List<Integer> group = list.get(list.size() - 1);
                if (group.size() < num) {
                    group.add(i);
                } else {
                    List<Integer> newGroup = new ArrayList<>();
                    newGroup.add(i);
                    list.add(newGroup);
                }
            } else {
                List<List<Integer>> list = new ArrayList<>();
                List<Integer> newGroup = new ArrayList<>();
                newGroup.add(i);
                list.add(newGroup);
                network.put(num, list);
            }
            i++;
        }

        for (Integer num : network.keySet()) {
            List<List<Integer>> list = network.get(num);
            for (List<Integer> group : list) {
                for (Integer index : group) {
                    System.out.print(index);
                    if(group.indexOf(index) != group.size()-1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }


}
