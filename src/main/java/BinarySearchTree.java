import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public static void main(String[] args) {
        BSTNode root = new BSTNode(14);
        insertNode(root, 7);
        insertNode(root, 23);
        insertNode(root, 9);
        insertNode(root, 17);
        insertNode(root, 31);
        System.out.println(deleteNode(root, root, 23));
//        System.out.println(findParent(root, 31).val);
        printBST(root);
    }

    private static void insertNode(BSTNode root, int val) {
        if (root == null) {
            root = new BSTNode(val);
        }

        if (val < root.val) {
            if (root.left == null)
                root.left = new BSTNode(val);
            else
                insertNode(root.left, val);
        } else {
            if (root.right == null)
                root.right = new BSTNode(val);
            else
                insertNode(root.right, val);
        }

    }

    private static boolean findNode(BSTNode root, int val) {
        if (root == null)
            return false;

        if (root.val == val)
            return true;

        if (val < root.val)
            return findNode(root.left, val);
        else
            return findNode(root.right, val);

    }

    private static boolean deleteNode(BSTNode root, BSTNode node, int val) {
        if (!findNode(node, val))
            return false;

        return deleteNodeHelper(root, node, val);
    }

    private static boolean deleteNodeHelper(BSTNode root, BSTNode node, int val) {

        if (node.val == val) {
            BSTNode parent = findParent(root, val);

            if (node.left == null && node.right == null) {
                if (parent != null) {
                    if (val < parent.val)
                        parent.left = null;
                    else
                        parent.right = null;
                } else {
                    root = null;
                }


            } else if (node.left == null) {
                if (parent != null) {
                    if (val < parent.val)
                        parent.left = node.right;
                    else
                        parent.right = node.right;
                } else {
                    root = null;
                }


            } else if (node.right == null) {
                if (parent != null) {
                    if (val < parent.val)
                        parent.left = node.left;
                    else
                        parent.right = node.left;
                } else {
                    root = null;
                }


            } else {
                BSTNode leftSubTreeMax = node.left;
                BSTNode leftMaxParent = node;
                while (leftSubTreeMax.right != null) {
                    leftMaxParent = leftSubTreeMax;
                    leftSubTreeMax = leftSubTreeMax.right;

                }
                if (leftMaxParent == node) {
                    leftSubTreeMax.left = node.left.left;
                } else {
                    leftSubTreeMax.left = node.left;
                }

                leftSubTreeMax.right = node.right;

                if(leftSubTreeMax.val < leftMaxParent.val) {
                    leftMaxParent.left = null;
                }else {
                    leftMaxParent.right = null;
                }

                if (parent != null) {
                    if (val < parent.val)
                        parent.left = leftSubTreeMax;
                    else
                        parent.right = leftSubTreeMax;
                } else {
                    root = leftSubTreeMax;
                }
            }
        } else {
            if (val < node.val)
                return deleteNodeHelper(root, node.left, val);
            else
                return deleteNodeHelper(root, node.right, val);
        }
        return true;
    }

    private static BSTNode findParent(BSTNode root, int val) {
        return findParentHelper(root, null, val);
    }

    private static BSTNode findParentHelper(BSTNode root, BSTNode currParent, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return currParent;

        currParent = root;
        if (root.val > val)
            return findParentHelper(root.left, currParent, val);
        else
            return findParentHelper(root.right, currParent, val);
    }

    private static void printBST(BSTNode root) {
        if(root == null)
            return;

        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);

        int curr = 1, next = 0;
        while(!queue.isEmpty()) {
            BSTNode node = queue.poll();

            if(node.left != null) {
                next++;
                queue.add(node.left);
            }

            if(node.right != null) {
                next ++;
                queue.add(node.right);
            }
            System.out.print(node.val + " ");
            curr--;

            if(curr == 0) {
                curr = next;
                next = 0;
                System.out.println();
            }

        }
    }

}

class BSTNode {
    int val;
    BSTNode left;
    BSTNode right;

    public BSTNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
