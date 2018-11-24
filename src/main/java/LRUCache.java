import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private Map<Integer, DoublyLinkedListNode> map;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = null;
//        String[] operation = {"LRUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};
//        String[] nums = {"10", "10,13", "3,17", "6,11", "10,5", "9,10", "13", "2,19", "2", "3", "5,25", "8", "9,22", "5,5", "1,30", "11", "9,12", "7", "5", "8", "9", "4,30", "9,3", "9", "10", "10", "6,14", "3,1", "3", "10,11", "8", "2,14", "1", "5", "4", "11,4", "12,24", "5,18", "13", "7,23", "8", "12", "3,27", "2,12", "5", "2,9", "13,4", "8,18", "1,7", "6", "9,29", "8,21", "5", "6,30", "1,12", "10", "4,15", "7,22", "11,26", "8,17", "9,29", "5", "3,4", "11,30", "12", "4,29", "3", "9", "6", "3,4", "1", "10", "3,29", "10,28", "1,20", "11,13", "3", "3,12", "3,8", "10,9", "3,26", "8", "7", "5", "13,17", "2,27", "11,15", "12", "9,19", "2,15", "3,16", "1", "12,17", "9,1", "6,19", "4", "5", "5", "8,1", "11,7", "5,2", "9,28", "1", "2,2", "7,4", "4,22", "7,24", "9,26", "13,28", "11,26"};
//        Integer[] expected = {null, null, null, null, null, null, -1, null, 19, 17, null, -1, null, null, null, -1, null, -1, 5, -1, 12, null, null, 3, 5, 5, null, null, 1, null, -1, null, 30, 5, 30, null, null, null, -1, null, -1, 24, null, null, 18, null, null, null, null, -1, null, null, 18, null, null, -1, null, null, null, null, null, 18, null, null, -1, null, 4, 29, 30, null, 12, -1, null, null, null, null, 29, null, null, null, null, 17, 22, 18, null, null, null, -1, null, null, null, 20, null, null, null, -1, 18, 18, null, null, null, null, 20, null, null, null, null, null, null, null};

        String[] operation = {"LRUCache","put","put","get","put","get","put","get","get","get"};
        String[] nums = {"2","1,1","2,2","1","3,3","2","4,4","1","3","4"};
        Integer[] expected = {null,null,null,1,null,-1,null,-1,3,4};

        Integer[] output = new Integer[operation.length];
        for (int i = 0; i < operation.length; i++) {
            switch (operation[i]) {
                case "LRUCache":
                    cache = new LRUCache(Integer.parseInt(nums[i]));
                    output[i] = null;
                    break;
                case "put":
                    cache.put(Integer.parseInt(nums[i].split(",")[0]), Integer.parseInt(nums[i].split(",")[1]));
                    output[i] = null;
                    break;
                case "get":
                    Integer ans = cache.get(Integer.parseInt(nums[i]));
                    output[i] = ans;
                    break;
            }
        }

        System.out.println(expected.length + " " + output.length + " ");
        for (int i = 0; i < output.length; i++) {
            if (!Objects.equals(output[i], expected[i])) {
                System.out.println("Mismatch at index " + i + ", Operation " + operation[i] + ", Value " + nums[i] + ", Expected " + expected[i] + ", Actual " + output[i]);
            }
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoublyLinkedListNode node = map.get(key);
            deleteNode(node);

            node.prev = null;
            node.next = null;

            addNewNode(node);
            return node.value;
        }

        return -1;
    }

    private void addNewNode(DoublyLinkedListNode node) {
        if (head == null && tail == null) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    private void deleteNode(DoublyLinkedListNode node) {
        if (node.prev == null && node.next == null) {
            tail = null;
            head = null;
        } else {
            if (node.prev != null && node.next != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else if (node.prev != null) {
                tail = node.prev;
                tail.next = null;
            } else {
                head = node.next;
                head.prev = null;
            }
        }
    }

    public void put(int key, int value) {
        DoublyLinkedListNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            deleteNode(node);

            node.value = value;
            node.prev = null;
            node.next = null;
        } else {
            if (map.size() == capacity) {
                map.remove(head.key);
                deleteNode(head);

                node = new DoublyLinkedListNode(key, value);
                map.put(key, node);
            } else {
                node = new DoublyLinkedListNode(key, value);
                map.put(key, node);
            }
        }
        addNewNode(node);
    }

}

class DoublyLinkedListNode {
    int key;
    int value;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
