class Solution {
    int answer = 0;
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            dfs(n, visited, computers, i, 0);
        }
        
        return answer;
    }
    
    public void dfs(int n, boolean[] visited, int[][] computers, int computer, int depth) {
        if (visited[computer]) return;
        visited[computer] = true;
        if (depth == 0) answer++;
        
        int[] network = computers[computer];
        for (int i = 0; i < n; i++) {
            if (i != computer && network[i] == 1) {
                dfs(n, visited, computers, i, depth + 1);
            } else continue;
        }
    }
}