import java.util.*;

public class L146LRUCache {

    private PriorityQueue<CacheElements> pq;
    private Map<Integer, CacheElements> map;
    private int capacity;
    private int curr;

    public L146LRUCache(int capacity) {
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.timestamp));
        map = new HashMap<>();
        this.capacity = capacity;
        this.curr = 0;
    }

    public static void main(String[] args) {
        L146LRUCache cache = null;
        String[] operation = {"LRUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};
        String[] nums = {"10", "10,13", "3,17", "6,11", "10,5", "9,10", "13", "2,19", "2", "3", "5,25", "8", "9,22", "5,5", "1,30", "11", "9,12", "7", "5", "8", "9", "4,30", "9,3", "9", "10", "10", "6,14", "3,1", "3", "10,11", "8", "2,14", "1", "5", "4", "11,4", "12,24", "5,18", "13", "7,23", "8", "12", "3,27", "2,12", "5", "2,9", "13,4", "8,18", "1,7", "6", "9,29", "8,21", "5", "6,30", "1,12", "10", "4,15", "7,22", "11,26", "8,17", "9,29", "5", "3,4", "11,30", "12", "4,29", "3", "9", "6", "3,4", "1", "10", "3,29", "10,28", "1,20", "11,13", "3", "3,12", "3,8", "10,9", "3,26", "8", "7", "5", "13,17", "2,27", "11,15", "12", "9,19", "2,15", "3,16", "1", "12,17", "9,1", "6,19", "4", "5", "5", "8,1", "11,7", "5,2", "9,28", "1", "2,2", "7,4", "4,22", "7,24", "9,26", "13,28", "11,26"};

        Integer[] output = new Integer[operation.length];
        for (int i = 0; i < operation.length; i++) {
            if (operation[i].equals("LRUCache")) {
                cache = new L146LRUCache(Integer.parseInt(nums[i]));
                output[i] = null;
            } else if (operation[i].equals("put")) {
                cache.put(Integer.parseInt(nums[i].split(",")[0]), Integer.parseInt(nums[i].split(",")[1]));
                output[i] = null;
            } else if (operation[i].equals("get")) {
                Integer ans = cache.get(Integer.parseInt(nums[i]));
                output[i] = ans;
            }
        }

        Integer[] expected = {null, null, null, null, null, null, -1, null, 19, 17, null, -1, null, null, null, -1, null, -1, 5, -1, 12, null, null, 3, 5, 5, null, null, 1, null, -1, null, 30, 5, 30, null, null, null, -1, null, -1, 24, null, null, 18, null, null, null, null, -1, null, null, 18, null, null, -1, null, null, null, null, null, 18, null, null, -1, null, 4, 29, 30, null, 12, -1, null, null, null, null, 29, null, null, null, null, 17, 22, 18, null, null, null, -1, null, null, null, 20, null, null, null, -1, 18, 18, null, null, null, null, 20, null, null, null, null, null, null, null};
        System.out.println(expected.length + " " + output.length + " ");
        for (int i = 0; i < output.length; i++) {
            if (!Objects.equals(output[i], expected[i])) {
                System.out.println("Mismatch at index " + i + ", Operation " + operation[i] + ", Value " + nums[i] + ", Expected " + expected[i] + ", Actual " + output[i]);
            }
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            CacheElements existingElement = map.get(key);
            pq.remove(existingElement);
            existingElement.timestamp = ++curr;
            pq.add(existingElement);
            return existingElement.value;
        }
        return -1;
    }


    public void put(int key, int value) {

        if (map.containsKey(key)) {
            CacheElements existingElement = map.get(key);
            pq.remove(existingElement);

            existingElement.timestamp = ++curr;
            existingElement.value = value;
            pq.add(existingElement);
        } else {
            if (map.size() == capacity) {
                CacheElements leastUsed = pq.poll();
                map.remove(leastUsed.key);

                CacheElements newElement = new CacheElements(key, value, ++curr);
                map.put(key, newElement);
                pq.add(newElement);
            } else {
                CacheElements newElement = new CacheElements(key, value, ++curr);
                map.put(key, newElement);
                pq.add(newElement);
            }
        }
    }
}

class CacheElements {
    int key;
    int value;
    int timestamp;

    CacheElements(int key, int value, int timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }
}
