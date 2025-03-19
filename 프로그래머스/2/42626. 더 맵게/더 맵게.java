import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int length = scoville.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < length; i++) {
            pq.add(scoville[i]);
        }
        
        int a;
        int b;
        
        while(true) {
            if (pq.peek() >= K) break;
            if (pq.peek() < K && pq.size() == 1) {
                answer = -1;
                break;
            }
            a = pq.poll();
            b = pq.poll();
            pq.add(a + 2*b);
            answer++;
        }
        
        
        
        return answer;
    }
}