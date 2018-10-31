import java.util.*;

public class L399EvaluateDivision {

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}, {"bc", "cd"}};
        double[] values = {1.5,2.5,5.0};
        String[][] queries = {{"a", "c"}, {"c","b"}, {"bc","cd"}, {"cd","bc"}};
        double[] result = calcEquation(equations, values, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> pairValues = new HashMap<>();

        for(int i=0; i<equations.length; i++) {
            String[] equation = equations[i];
            if(!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<>());
                pairValues.put(equation[0], new ArrayList<>());
            }

            if(!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<>());
                pairValues.put(equation[1], new ArrayList<>());
            }

            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            pairValues.get(equation[0]).add(values[i]);
            pairValues.get(equation[1]).add(1.0/values[i]);
        }

        System.out.println(pairs);
        System.out.println(pairValues);
        double[] result = new double[queries.length];

        for(int i=0; i<queries.length; i++) {
            String[] query = queries[i];
            double ans = computeDFS(query[0], query[1], pairs, pairValues, new HashSet<>(), 1.0);
            if(ans == 0.0)
                result[i] = -1.0;
            else
                result[i] = ans;
        }

        return result;
    }

    private static double computeDFS(String arg1, String arg2, Map<String, List<String>> pairs, Map<String, List<Double>> pairValues, Set<String> visited, double ans) {
        if(visited.contains(arg1)) return 0.0;
        if(!pairs.containsKey(arg1) || !pairs.containsKey(arg2)) return 0.0;

        visited.add(arg1);

        for(int j=0; j<pairs.get(arg1).size(); j++) {
            String temp = pairs.get(arg1).get(j);
            if(temp.equals(arg2))
                return ans * pairValues.get(arg1).get(j);

            double result = computeDFS(temp, arg2, pairs, pairValues, visited, ans*pairValues.get(arg1).get(j));
            if(result != 0.0)
                return result;
        }
        return 0.0;
    }

 }
