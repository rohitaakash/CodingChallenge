import java.util.*;

public class AscendingBinarySorting {

    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(7,8,6,5);
        System.out.println(rearrange(elements));
    }

    private static List<Integer> rearrange(List<Integer> elements) {
        List<BinaryRepresentation> list = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            BinaryRepresentation br = new BinaryRepresentation();
            br.num = elements.get(i);
            br.ones = countOnes(Integer.toBinaryString(elements.get(i)));
            br.index = i;
            list.add(br);
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.ones == o2.ones) {
                return o1.num - o2.num;
            } else {
                return o1.ones - o2.ones;
            }
        });

        List<Integer> output = new ArrayList<>();
        for(BinaryRepresentation br: list) {
            output.add(elements.get(br.index));
        }

        return output;
    }

    private static int countOnes(String binary) {
        int ones = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') ones++;
        }
        return ones;
    }

    static class BinaryRepresentation {
        int num;
        int ones;
        int index;
    }

}


