import java.util.*;

public class L103BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        List<List<Integer>> result = new ArrayList<>();
        int i = 1;

        stack1.push(root);
        while(!stack2.isEmpty() || !stack1.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            if(i%2 == 0){
                while(!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    if(node.right!=null) stack1.push(node.right);
                    if(node.left!=null) stack1.push(node.left);
                    temp.add(node.val);
                }
            }else{
                while(!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    if(node.left!=null) stack2.push(node.left);
                    if(node.right!=null) stack2.push(node.right);
                    temp.add(node.val);
                }
            }
            result.add(temp);
            i++;
        }
        return result;
    }
}
