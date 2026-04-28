import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for (int i = 0; i < n; i++) parent[i] = i;
        
        boolean[] check = new boolean[n];
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        for (int[] e : costs) {
            int a = find(e[0]);
            int b = find(e[1]);
            
            if (a == b) continue;

            parent[b] = parent[a];
            answer += e[2];            
        }
        return answer;
    }
    
    int find(int c) {
        if (parent[c] != c) {
            return find(parent[c]);
        }
        return parent[c];
    }
}