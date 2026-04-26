import java.util.*;

class Solution {
    int total;
    boolean[] check;
    String[] answer;
    
    
    
    
    public String[] solution(String[][] tickets) {
        total = tickets.length;
        check = new boolean[total];
        
        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        String current = "ICN";
        
        dfs(tickets, path, current);
        
        answer = path.toArray(new String[0]);
        
        
        return answer;
    }
    
    public boolean dfs(String[][] tickets, List<String> path, String current) {
        if (path.size() == total + 1) {
            return true;
        }
        
        for (int i = 0; i < total; i++) {
            if (tickets[i][0].equals(current) && !check[i]) {
                check[i] = true;
                String dest = tickets[i][1];
                path.add(dest);
                
                if (dfs(tickets, path, dest)) return true;
                check[i] = false;
                path.remove(path.size() - 1);
            }
        }
        return false;
        
    }
    
    
    
}