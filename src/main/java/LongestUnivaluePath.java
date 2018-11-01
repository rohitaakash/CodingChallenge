
public class LongestUnivaluePath {

	static int result = 0;

	public static int longestUnivaluePath(TreeNode root) {
		getLongestPath(root);
		return result;

	}

	public static int getLongestPath(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = getLongestPath(root.left);
		int right = getLongestPath(root.right);

		int leftPath = 0, rightPath = 0;
		if (root.left != null && root.left.val == root.val) {
			leftPath = left + 1;
		} else {
			leftPath = 0;
		}

		if (root.right != null && root.right.val == root.val) {
			rightPath = right + 1;
		}else {
			rightPath = 0;
		}

		result = Math.max(result, leftPath + rightPath);

		return Math.max(leftPath, rightPath);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(4);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(4);

		System.out.println(longestUnivaluePath(root));
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
