import java.util.*;

public class PrimesInSubtree {

    public static List<Node> createNodeList(int n, List<Integer> values) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(null);

        for (Integer value : values) {
            nodeList.add(new Node(value));
        }

        return nodeList;
    }

    public static List<Integer> findChildren(int node_id, List<Pair> edgeList, Set<Integer> visited) {

        List<Integer> childList = new ArrayList<>();
        List<Pair> edgesToDelete = new ArrayList<>();

        for (Pair p : edgeList) {
            if (p.a == p.b)
                continue;
            if (p.a == node_id && !visited.contains(p.b)) {
                childList.add(p.b);
                edgesToDelete.add(p);
            }

            if (p.b == node_id && !visited.contains(p.a)) {
                childList.add(p.a);
                edgesToDelete.add(p);
            }
        }

        for (Pair p : edgesToDelete) {
            edgeList.remove(p);
        }
        return childList;
    }

    public static void createEdge(int n1, int n2, List<Node> nodeList) {
        nodeList.get(n1).children.add(new ChildPair(n2, nodeList.get(n2)));
    }

    public static boolean isPrime(int n) {

        //		return !new String(new char[n]).matches(".?|(..+?)\\1+");
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }

    public static boolean[] primesLessThan(int N) {
        boolean[] isPrime = new boolean[N+1];
        for(int i=0; i<isPrime.length; i++) {
            isPrime[i] = true;
        }

        for(int i=2; i*i<=N; i++) {
            if(isPrime[i]) {
                for(int j = i*2; j<=N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;

    }

    public static int dfs(Node rootNode, int rootId, Set<Integer> primeDict, Map<Integer, Integer> visitedPrimeDict) {

        if (visitedPrimeDict.containsKey(rootId))
            return visitedPrimeDict.get(rootId);

        int currSum = 0;

        if (primeDict.contains(rootNode.val))
            currSum++;

        for (ChildPair p : rootNode.children) {
            currSum += dfs(p.node, p.id, primeDict, visitedPrimeDict);
        }

        visitedPrimeDict.put(rootId, currSum);
        return currSum;

    }

    private static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values, List<Integer> queries) {

        List<Integer> result = new ArrayList<>();
        List<Node> nodeList = createNodeList(n, values);
        List<Pair> edgeList = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int N = Integer.MIN_VALUE;
        for(Integer val: values) {
            if(val > N)
                N = val;
        }

        for (int i = 0; i < first.size(); i++) {
            edgeList.add(new Pair(first.get(i), second.get(i)));
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int currNodeId;
        List<Integer> currChildList;

        while (!q.isEmpty()) {
            currNodeId = q.poll();
            currChildList = findChildren(currNodeId, edgeList, visited);

            for (int childId : currChildList) {
                createEdge(currNodeId, childId, nodeList);
                q.add(childId);
            }
            visited.add(currNodeId);
        }

        Set<Integer> primeDict = new HashSet<>();
        boolean[] isPrime = primesLessThan(N);
        for (int val : values) {
            if (isPrime[val]) {
                primeDict.add(val);
            }
        }

        Map<Integer, Integer> visitedPrimeDict = new HashMap<>();

        for (int query : queries) {
            result.add(dfs(nodeList.get(query), query, primeDict, visitedPrimeDict));
        }

        return result;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<Integer> first = Arrays.asList(6, 8, 3, 6, 4, 1, 8, 5, 1);
        List<Integer> second = Arrays.asList(9, 9, 5, 7, 8, 8, 10, 8, 2);
        List<Integer> values = Arrays.asList(17, 29, 3, 20, 11, 8, 3, 23, 5, 15);
        List<Integer> queries = Arrays.asList(1, 8, 9, 6, 4, 3);
        int n = 10;

        System.out.println(primeQuery(n, first, second, values, queries));
    }

    static class Node {
        int val;
        List<ChildPair> children;

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            // TODO Auto-generated constructor stub
            this.a = a;
            this.b = b;
        }
    }

    static class ChildPair {
        int id;
        Node node;

        public ChildPair(int id, Node node) {
            // TODO Auto-generated constructor stub
            this.id = id;
            this.node = node;
        }
    }

}
