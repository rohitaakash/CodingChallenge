import java.util.HashMap;
import java.util.Map;

public class L138CopyListWithRandomPointer {

    public static void main(String[] args) {

    }

    private static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;

        RandomListNode copy = new RandomListNode(head.label);
        RandomListNode tempCopy = copy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, copy);

        RandomListNode temp = head;
        while(temp.next != null) {
            RandomListNode newNodeCopy = new RandomListNode(temp.next.label);
            map.put(temp.next, newNodeCopy);
            tempCopy.next = newNodeCopy;
            tempCopy = newNodeCopy;
            temp = temp.next;
        }

        tempCopy.next = null;

        for(RandomListNode original: map.keySet()) {
            if(original.random != null) {
                RandomListNode originalRandomNode = original.random;
                RandomListNode copyNode = map.get(original);
                copyNode.random = map.get(originalRandomNode);
            }else{
                map.get(original).random = null;
            }
        }

        return copy;
    }
}

//Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};