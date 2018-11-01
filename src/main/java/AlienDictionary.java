import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] dict = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienDictionary(dict));
    }

    private static List<Character> alienDictionary(String[] dict) {

        Set<Character> nodes = new HashSet<>();
        for(String word: dict){
            for(int i = 0; i < word.length(); i++) {
                nodes.add(word.charAt(i));
            }
        }

        Map<Character, Set<Character>> adjMap = new HashMap<>();
        for(Character node: nodes) {
            adjMap.put(node, new HashSet<>());
        }

        for (int i = 0; i < dict.length - 1; i++) {
            String first = dict[i];
            String second = dict[i + 1];
            int minLength = (first.length() > second.length()) ? second.length() : first.length();
            for (int j = 0; j < minLength; j++) {
                char charFirst = first.charAt(j);
                char charSecond = second.charAt(j);
                if (charFirst != charSecond) {
                    adjMap.get(charFirst).add(charSecond);
                }
            }
        }

        return topologicalSort(adjMap);
    }

    private static List<Character> topologicalSort(Map<Character, Set<Character>> adjMap) {
        List<Character> sortedNodes = new ArrayList<>();
        Set<Character> visited = new HashSet<>();

        Stack<Character> dfsStack = new Stack<>();
        Stack<Character> dumpStack;
        for(Character node: adjMap.keySet()) {

            if(!visited.contains(node)) {
                dfsStack.push(node);
            } else {
                continue;
            }

            dumpStack = new Stack<>();
            while(!dfsStack.isEmpty()) {
                Character vertex = dfsStack.pop();
                visited.add(vertex);

                for(Character v: adjMap.get(vertex)) {
                    if(!visited.contains(v)) {
                        dfsStack.push(v);
                    }
                }
                dumpStack.push(vertex);
            }

            while(!dumpStack.isEmpty()) {
                sortedNodes.add(dumpStack.pop());
            }
        }
        Collections.reverse(sortedNodes);
        return sortedNodes;
    }
}
