import java.util.ArrayList;

public class KthSmallestElementBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(4);
        root.right = new TreeNode(17);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        KthSmallestElementBST kthSmallestElementBST = new KthSmallestElementBST();
        System.out.println(kthSmallestElementBST.kthSmallest(root, 3));

    }

    private int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list.get(k - 1);

    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        if (root.left != null) inorderTraversal(root.left, list);
        list.add(root.val);
        if (root.right != null) inorderTraversal(root.right, list);

    }

}
