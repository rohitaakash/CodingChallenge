
public class RemoveNthNodeLinkedList {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		RemoveNthNodeLinkedList rn = new RemoveNthNodeLinkedList();
		rn.printList(head);
		
		rn.printList(rn.removeNthFromEnd(head, 2));
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp1 = head;
		ListNode temp2 = head;

		for (int i = 1; i <= n; i++) {
			temp2 = temp2.next;
		}
		
		if(temp2 == null) return head.next;

		while (temp2 != null) {
			if(temp2.next != null) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}else {
				temp1.next = temp1.next.next;
				temp2 = temp2.next;
			}
			
		}
		return head;
	}
	
	public void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val);
			if(head.next != null) System.out.print("->");
			head = head.next;
		}
		System.out.println();
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}