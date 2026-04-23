import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera;
        
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < routes.length; i++) {
            list.add(routes[i]);
        }
        
        list.sort((a,b) -> a[1] - b[1]);
        
        answer++;
        camera = list.get(0)[1];
        for (int i = 1; i < routes.length; i++) {
            
            if (camera >= list.get(i)[0] && camera <= list.get(i)[1]) continue;
            answer++;
            camera = list.get(i)[1];
        }
        
        
        
        
        
        

        return answer;
    }
}