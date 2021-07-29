import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienDict {

    public static class Node {

        int indegree;
        List<Character> neighbors;

        Node() {
            this.indegree = 0;
            neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // String words[] = new String[] { "caa", "aaa", "aab" };
        String words[] = new String[] { "a", "a", "a" };

        // find the indegree of each word graph and do topological sort
        // part 1 - preprocessing and graph construction
        // ["b", { indegree: 0, neighbors ["a"]}]
        // ["a",{indegree: 1, neighbors["c"]}]
        Map<Character, Node> map = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            int len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    map.putIfAbsent(word1.charAt(j), new Node());
                    map.putIfAbsent(word2.charAt(j), new Node());
                    map.get(word2.charAt(j)).indegree++;
                    map.get(word1.charAt(j)).neighbors.add(word2.charAt(j));
                }
            }
        }

        for (Map.Entry<Character, Node> res : map.entrySet()) {
            Node n = res.getValue();
            System.out.println(res.getKey() + " " + n.indegree);
            // n.neighbors.forEach(System.out::println);
        }

        // System.out.println(map.get('a').neighbors.toString());

        System.out.println(map.size());
        // System.out.println(map.get('b').neighbors.toString());
        // System.out.println(map.get('c').neighbors.toString());
    }
}
