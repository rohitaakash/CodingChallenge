public class VisibleNodesInBinaryTree {

    public static int numberOfVisibleNodes(Tree root) {

        return numberOfVisibleNodes(root, Integer.MIN_VALUE);

    }

    private static int numberOfVisibleNodes(Tree root, int maxInPath) {
        if (root == null) return 0;

        if (root.val < maxInPath)
            return numberOfVisibleNodes(root.l, maxInPath) + numberOfVisibleNodes(root.r, maxInPath);

        return 1 + numberOfVisibleNodes(root.l, root.val) + numberOfVisibleNodes(root.r, root.val);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Tree root = new Tree(5);
        root.l = new Tree(3);
        root.r = new Tree(10);
        root.l.l = new Tree(20);
        root.l.r = new Tree(21);
        root.r.l = new Tree(1);

        System.out.println(numberOfVisibleNodes(root));
    }


}

class Tree {

    public int val;
    public Tree l;
    public Tree r;

    public Tree(int v) {
        val = v;
    }
}
