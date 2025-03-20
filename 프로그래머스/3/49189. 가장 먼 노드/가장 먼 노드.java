import java.util.*;

class Solution {
    
    int answer = 0;
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    int[] depths;
    
    public int solution(int n, int[][] edge) {
        
        visited = new boolean[n];
        depths = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int j = 0; j < edge.length; j++) {
            int node1 = edge[j][0] - 1;
            int node2 = edge[j][1] - 1;
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        depths[0] = 0;
        bfs(n, 0);
        
        int maxDepth = 0;
        for (int i = 0; i < n; i++) {
            if (depths[i] > maxDepth) maxDepth = depths[i];
        }
        for (int i = 0; i < n; i++) {
            if (depths[i] == maxDepth) answer++;
        }
        
        return answer;
    }
    
    public void bfs(int n, int start) {
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            int current = q.remove();
            for (int next : graph.get(current)) {
                if (visited[next]) continue;
                visited[next] = true;
                depths[next] = depths[current] + 1;
                q.add(next);
            }
        }
    }
}