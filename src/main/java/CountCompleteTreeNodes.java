
public class CountCompleteTreeNodes {

	public static void main(String[] args) {

	}

	public int countNodes(BTNode root) {
		
if(root == null) return 0;
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		if(leftHeight == rightHeight) return (1 << leftHeight) + countNodes(root.right);
		else return (1 << rightHeight) + countNodes(root.left);
		
	}
	
	public int getHeight(BTNode root) {
		int height = 0;
		while(root != null) {
			height += 1;
			root = root.left;
		}
		
		return height;
	}

}

class Node {
	int val;
	BTNode left;
	BTNode right;

	Node(int x) {
		val = x;
	}
}