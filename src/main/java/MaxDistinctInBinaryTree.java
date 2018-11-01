import java.util.HashSet;

public class MaxDistinctInBinaryTree {

    public static int numberOfDistinct(BeaconTree T) {
        if(T ==null)
            return 0;
        return helper(T,new HashSet<>());
    }

    public static int helper(BeaconTree root, HashSet<Integer> set) {
        if(root == null)
            return set.size();

        set.add(root.x);
        int leftMax = helper(root.l, set);
        int rightMax = helper(root.r, set);

        set.remove(root.x);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub


    }
}
 class BeaconTree {
    int x;
    BeaconTree l;
    BeaconTree r;
}
