import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
    int noOfVertices;
    Map<Integer, List<Integer>> map;
    boolean isDirected;

    public static void main(String[] args) {
        // cycle
        int[][] cycleEdges = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 2 }, { 4, 5 }, { 3, 6 }, { 6, 4 } };
        // no cycle
        int[][] noCycleEdges = new int[][] { { 1, 2 }, { 2, 3 }, { 2, 4 }, { 4, 5 }, { 5, 6 } };
        // undirected graph
        Graph graph = new Graph(6, noCycleEdges, false);

        // directed graph
        Graph graph1 = new Graph(6, cycleEdges, true);

        // graph.addEdge(0, 1);
        // graph.addEdge(0, 2);
        // graph.addEdge(1, 2);
        // graph.addEdge(2, 3);
        // graph.addEdge(2, 4);
        // graph.addEdge(4, 5);

        // BFS
        System.out.println("*****BFS*****");
        graph.BFSHelper(1);

        // DFS
        System.out.println("*****DFS - METHOD 1*****");
        graph.DFSHelper();
        System.out.println("*****DFS - METHOD 2*****");
        graph.DFSHelper2();
        System.out.println("*****DFS DETECT CYCLE*****");
        boolean isCycle = graph.DFSCycleHelper();
        System.out.println(isCycle);
        System.out.println("*****DIRECTED GRAPH - DFS DETECT CYCLE*****");
        System.out.println(graph1.detectCycleInDirectedGraph());
    }

    public Graph(int noOfVertices, int[][] edges, boolean isDirected) {
        this.noOfVertices = noOfVertices;
        this.isDirected = isDirected;
        this.map = new HashMap<>();

        for (int i = 1; i <= noOfVertices; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            if (!isDirected) {
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            } else {
                map.get(edge[0]).add(edge[1]);
            }
        }

    }

    // public void addEdge(int s, int e) {
    // map.get(s).add(e);
    // }

    public void print() {
        for (int neighbor : map.get(1)) {
            System.out.println(neighbor);
        }
    }

    // DFS METHOD -1
    public void DFSHelper() {
        // a visited boolean array willl hold value to say if a vertice is visited or
        // not
        // this is needed so we dont get into a cycle
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 1; i <= noOfVertices; i++) {
            if (!visited[i - 1]) {
                dfsVisist(i, visited);
            }
        }
    }

    public void dfsVisist(int current, boolean[] visited) {
        visited[current - 1] = true;
        System.out.println("Vertex " + current + " is being visited: " + visited[current - 1]);
        for (int neighbor : map.get(current)) {
            if (!visited[neighbor - 1]) {
                dfsVisist(neighbor, visited);
            }
        }
        System.out.println("Vertex " + current + " and all its beighbors are visited: " + visited[current - 1]);
    }

    // DFS METHOD - 2
    public void DFSHelper2() {
        // a visited int array willl hold value to say if a vertice is
        // 0 unvisited
        // 1 being visisted
        // 2 already visited
        // this template is needed in few implementations.
        int[] visited = new int[noOfVertices];
        for (int i = 1; i <= noOfVertices; i++) {
            if (visited[i - 1] == 0) {
                dfsVisist2(i, visited);
            }
        }
    }

    public void dfsVisist2(int current, int[] visited) {
        visited[current - 1] = 1;
        System.out.println("Vertex " + current + " is being visited: " + visited[current - 1]);
        for (int neighbor : map.get(current)) {
            if (visited[neighbor - 1] == 0) {
                dfsVisist2(neighbor, visited);
            }
        }
        visited[current - 1] = 2;
        System.out.println("Vertex " + current + " and all its neighbors are visited: " + visited[current - 1]);
    }

    // DFS HAS CYCLE
    public boolean DFSCycleHelper() {
        // a visited int array willl hold value to say if a vertice is
        // 0 unvisited
        // 1 visisted
        // this template is needed in few implementations.
        Set<Integer> visited = new HashSet<Integer>();
        boolean cycle = false;
        for (int i = 1; i <= noOfVertices; i++) {
            if (!visited.contains(i)) {
                cycle = dfsHasCycle(i, visited, 0);
                if (cycle) {
                    return cycle;
                }

            }
        }
        return cycle;
    }

    public boolean dfsHasCycle(int current, Set<Integer> visited, int parent) {
        visited.add(current);
        for (int neighbor : map.get(current)) {
            System.out.println("*****");
            System.out.println(neighbor);
            // neighbor is not visisted && but there is a cycle
            // if (visited[neighbor - 1] == 0 && dfsHasCycle(neighbor, visited, current)) {
            // return true;
            // neighbor is visted but its not its direct parent
            // } else if (visited[neighbor - 1] == 1 && neighbor != parent) {
            // return true;
            // }

            // **** *

            if (neighbor == parent) {
                continue;
            }
            if (visited.contains(neighbor)) {
                return true;
            }
            boolean hasCycle = dfsHasCycle(neighbor, visited, current);
            if (hasCycle) {
                return true;
            }
        }

        return false;
    }

    public void BFSHelper(int source) {

        // queey DS to hold the vertices in the order BFS traverses - level order
        // offer or add will insert the element into queue.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        // a visited boolean array willl hold value to say if a vertice is visited or
        // not.
        // this is needed so we dont get into a cycle
        boolean[] visited = new boolean[noOfVertices];
        visited[source - 1] = true;
        // we can keep track of level - initalize
        int level = 1;
        // iterate over element in queue (if not emepty) and add its edges into queue
        while (!queue.isEmpty()) {
            // to keep track of count iterate only for the size of queue.
            int size = queue.size();
            for (int j = 1; j <= size; j++) {
                int top = queue.poll();
                // BFS traversal - print
                System.out.println("Vertex " + top + " is at Level" + level);

                for (int i : map.get(top)) {
                    // if not visited then add and mark it as visited
                    System.out.println(i);
                    if (!visited[i - 1]) {
                        queue.offer(i);
                        visited[i - 1] = true;
                    }
                }
            }
            // increment level when parent level is iterated and child level is added to
            // queue
            level++;
        }

    }

    public boolean detectCycleInDirectedGraph() {
        Set<Integer> white = new HashSet<>();
        Set<Integer> black = new HashSet<>();
        Set<Integer> grey = new HashSet<>();

        for (int i = 1; i <= noOfVertices; i++) {
            white.add(i);
        }

        while (!white.isEmpty()) {
            int current = white.iterator().next();
            if (dfsDetectCycleInDirectedGraph(current, white, grey, black)) {
                return true;
            }
        }

        return false;
    }

    public boolean dfsDetectCycleInDirectedGraph(int current, Set<Integer> white, Set<Integer> grey,
            Set<Integer> black) {
        white.remove(current);
        grey.add(current);

        for (int neighbor : map.get(current)) {
            // if black contains neighbor then ignore and continue as there is no direction
            // from black neighbor to visit current
            // (vice cersa is true) that is the case with undirected graphs
            if (black.contains(neighbor)) {
                continue;
            }

            // if its found in grey set then there is a cycle
            if (grey.contains(neighbor)) {
                return true;
            }

            // keep calling dfs untill all neighbors are visisted
            if (dfsDetectCycleInDirectedGraph(neighbor, white, grey, black))
                return true;

        }

        // once all neighbors are visisted then mark that node as visited (black)
        grey.remove(current);
        black.add(current);
        return false;
    }

}
