import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);
        
        int answer = 0;
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            
            int mid = (left + right) / 2;;
            
            int current = 0;
            int cnt = 0;
            
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - current < mid) {
                    cnt++;
                    continue;
                }
                current = rocks[i];
            }
            
            if (distance - current < mid) cnt++;
            
            if (cnt <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}