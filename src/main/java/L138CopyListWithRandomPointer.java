import java.util.HashMap;
import java.util.Map;

public class L138CopyListWithRandomPointer {

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.next.next.next.next.next = new RandomListNode(6);
        printRandomListNode(head);
        printRandomListNode(copyRandomListOptimized(head));
    }

    private static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode copy = new RandomListNode(head.label);
        RandomListNode tempCopy = copy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, copy);

        RandomListNode temp = head;
        while (temp.next != null) {
            RandomListNode newNodeCopy = new RandomListNode(temp.next.label);
            map.put(temp.next, newNodeCopy);
            tempCopy.next = newNodeCopy;
            tempCopy = newNodeCopy;
            temp = temp.next;
        }

        tempCopy.next = null;

        for (RandomListNode original : map.keySet()) {
            if (original.random != null) {
                RandomListNode originalRandomNode = original.random;
                RandomListNode copyNode = map.get(original);
                copyNode.random = map.get(originalRandomNode);
            } else {
                map.get(original).random = null;
            }
        }

        return copy;
    }

    private static RandomListNode copyRandomListOptimized(RandomListNode head) {
        if (head == null) return null;

        RandomListNode original = head;
        while (original != null) {
            RandomListNode copy = new RandomListNode(original.label);
            copy.next = original.next;
            original.next = copy;
            original = copy.next;
        }

        original = head;
        while (original != null) {
            if (original.random != null) original.next.random = original.random.next;
            original = original.next.next;
        }

        original = head;
        RandomListNode copyHead = head.next;
        while (original != null) {
            RandomListNode copy = original.next;
            original.next = original.next.next;
            if(copy.next != null) copy.next = copy.next.next;
            original = original.next;
        }

        return copyHead;
    }

    private static void printRandomListNode(RandomListNode head) {
        RandomListNode temp = head;
        while(temp != null) {
            System.out.print(temp.label);
            temp = temp.next;
            if(temp != null)
                System.out.print("->");
        }
        System.out.println();
    }
}

//Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}