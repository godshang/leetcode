package q399_evaluate_division;

import common.Util;

import java.util.*;

public class Solution {

    private Map<String, String> parents = new HashMap<>();
    private Map<String, Double> vals = new HashMap<>();

    public void add(String x) {
        if (!parents.containsKey(x)) {
            parents.put(x, x);
            vals.put(x, 1.0);
        }
    }
    
    public String root(String x) {
        while (!parents.get(x).equals(x)) {
            x = parents.get(x);
        }
        return x;
    }
    
    private double pm(String x) {
        double v = 1;
        while (!parents.get(x).equals(x)) {
            v *= vals.get(x);
            x = parents.get(x);
        }
        return v;
    }

    public void union(String x, String y, Double val) {
        add(x);
        add(y);
        String px = root(x), py = root(y);
        if (!px.equals(py)) {
            parents.put(px, py);
            vals.put(px, val * pm(y) / pm(x));
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            union(equation.get(0), equation.get(1), value);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String x = query.get(0), y = query.get(1);
            if (!parents.containsKey(x) || !parents.containsKey(y) || !root(x).equals(root(y))) {
                res[i] = -1;
            } else {
                res[i] = pm(x) / pm(y);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

//        List<List<String>> equations = new ArrayList<>();
//        equations.add(Arrays.asList("a", "b"));
//        equations.add(Arrays.asList("b", "c"));
//        double[] values = {2.0, 3.0};
//        List<List<String>> queries = new ArrayList<>();
//        queries.add(Arrays.asList("a", "c"));
//        queries.add(Arrays.asList("b", "a"));
//        queries.add(Arrays.asList("a", "e"));
//        queries.add(Arrays.asList("a", "a"));
//        queries.add(Arrays.asList("x", "x"));
//        double[] res = solution.calcEquation(equations, values, queries);
//        Util.printArray(res);

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("e", "f"));
        equations.add(Arrays.asList("b", "e"));
        double[] values = {3.4, 1.4, 2.3};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "f"));
        queries.add(Arrays.asList("f", "f"));
        queries.add(Arrays.asList("e", "e"));
        queries.add(Arrays.asList("c", "c"));
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("f", "e"));
        double[] res = solution.calcEquation(equations, values, queries);
        Util.printArray(res);
    }
}
