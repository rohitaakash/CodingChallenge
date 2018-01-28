
public class BSTSearchElement {

	public static void main(String[] args) {
		Node1 root = new Node1(50);
		root.left = new Node1(38);
		root.right = new Node1(70);
		root.left.left = new Node1(37);
		root.left.right = new Node1(41);
		root.right.left = new Node1(55);
		root.right.right = new Node1(73);
		
		System.out.println(isPresent(root, 59));
	}
	
	public static int isPresent(Node1 root, int val) {
		if(root == null) return 0;
		if(root.val == val) return 1;
		else {
			if(root.val > val) return isPresent(root.left, val);
			else return isPresent(root.right, val);
		}
	}
	
}

class Node1{
	int val;
	Node1 left;
	Node1 right;
	
	Node1(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}