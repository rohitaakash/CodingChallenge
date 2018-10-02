import java.util.*;

public class ArrayClosestIdenticalElement {
    public static void main(String[] args) {
        String s = "aaaa";
        List<Integer> queries = Arrays.asList(0,1,2,3);
        System.out.println(closest(s, queries));
        System.out.println(closestIdentical(s, queries));

    }

    private static List<Integer> closestIdentical(String s, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();

        for (Integer i : queries) {
            int left = i - 1;
            int right = i + 1;
            boolean flag = false;
            while (left >= 0 || right < s.length() - 1) {
                if (left >= 0) {
                    if (s.charAt(left) == s.charAt(i)) {
                        result.add(left);
                        flag = true;
                        break;
                    } else {
                        left--;
                    }
                }

                if (right < s.length() - 1) {
                    if (s.charAt(right) == s.charAt(i)) {
                        result.add(right);
                        flag = true;
                        break;
                    } else {
                        right++;
                    }
                }
            }
            if (!flag)
                result.add(-1);
        }
        return result;
    }

    private static List<Integer> closest(String s, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s.charAt(i), list);
            }
        }

        for (Integer i : queries) {
            result.add(binarySearchClosest(map.get(s.charAt(i)), i, 0, map.get(s.charAt(i)).size()-1));
        }
        return result;
    }

    private static int binarySearchClosest(List<Integer> list, int target, int start, int end) {

        if(start > end) return -1;
        int mid = (start + end)/2;
        if(list.get(mid) == target) {
            int leftDiff = Integer.MAX_VALUE, rightDiff = Integer.MAX_VALUE;
            if(mid > 0) {
                leftDiff = target - list.get(mid-1);
            }
            if(mid < list.size()-1) {
                rightDiff = list.get(mid+1) - target;
            }
            if(leftDiff == rightDiff && leftDiff == Integer.MAX_VALUE)
                return -1;
            else if(rightDiff < leftDiff )
                return list.get(mid+1);
            else
                return list.get(mid-1);
        }else{
            if(target < list.get(mid))
                return binarySearchClosest(list, target, start, mid-1);
            else
                return binarySearchClosest(list, target, mid+1, end);
        }

    }
}
