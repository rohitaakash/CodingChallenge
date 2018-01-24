import java.util.ArrayList;

public class KthSmallestElementBST {

	public int kthSmallest(TreeNode1 root, int k) {
		
		ArrayList<Integer> list = new ArrayList<>();
		inorderTraversal(root, list);
		return list.get(k-1);

	}
	
	public void inorderTraversal(TreeNode1 root, ArrayList<Integer> list) {
		if(root == null) return;
		
		if(root.left != null) inorderTraversal(root.left, list);
		list.add(root.val);
		if(root.right != null) inorderTraversal(root.right, list);
		
	}
	
	public static void main(String[] args) {
		
		TreeNode1 root = new TreeNode1(15);
		root.left = new TreeNode1(4);
		root.right = new TreeNode1(17);
		root.left.left = new TreeNode1(3);
		root.left.right = new TreeNode1(8);
		root.left.right.right = new TreeNode1(9);
		
		KthSmallestElementBST kthSmallestElementBST = new KthSmallestElementBST();
		System.out.println(kthSmallestElementBST.kthSmallest(root, 3));
		
	}

}

class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;

	TreeNode1(int x) {
		val = x;
	}
}
