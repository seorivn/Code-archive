import java.util.*;

class Solution {
    boolean[] visited = null;
    List<Integer>[] graph = null;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] w : wires) {
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            visited = new boolean[n + 1];
            int count = dfs(a, a, b);
            int diff = Math.abs(n - 2 * count);

            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    public int dfs(int node, int cutA, int cutB) {
        visited[node] = true;
        int count = 1;

        for (int next : graph[node]) {
            if ((node == cutA && next == cutB) || (node == cutB && next == cutA)) continue;

            if (!visited[next]) {
                count += dfs(next, cutA, cutB);
            }
        }
        return count;
    }
}