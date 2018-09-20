

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LowestCommonAncestor {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(30);
		bst.insert(8);
		bst.insert(52);
		bst.insert(3);
		bst.insert(20);
		bst.insert(10);
		bst.insert(29);

		while ((line = in.readLine()) != null) {
			if (line.length() != 0) {
				String[] arr = line.split("\\s");
				if (arr.length > 0) {
					int n1 = Integer.parseInt(arr[0]);
					int n2 = Integer.parseInt(arr[1]);
					System.out.println(bst.lowestCommonAncestor(bst.root, n1, n2).key);
				}
			}else {
				return;
			}
		}
	}

}

class BTNode {
	int key;
	BTNode left;
	BTNode right;

	public BTNode(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	public BTNode() {
	}
}

class BinarySearchTree {

	BTNode root;

	private BTNode insert(BTNode node, int value) {
		if (node != null) {
			if (value <= node.key) {
				node.left = insert(node.left, value);
			} else {
				node.right = insert(node.right, value);
			}
		} else {
			return new BTNode(value);
		}
		return node;
	}

	public void insert(int key) {
		root = insert(root, key);
	}

	public BTNode lowestCommonAncestor(BTNode node, int a, int b) {

		if (node == null) {
			return null;
		}
		if (node.key > a && node.key > b) {
			return lowestCommonAncestor(node.left, a, b);
		}
		if (node.key < a && node.key < b) {
			return lowestCommonAncestor(node.right, a, b);
		}
		return node;
	}

}
