import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int length = priorities.length;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < length; i++) {
            q.add(priorities[i]);
        }
        Arrays.sort(priorities);
        
        int priority = length - 1;
        int pointer = 0;
        
        while(true) {
            if (q.peek() == priorities[priority]) {
                if (pointer == location) break;
                priority--;
                q.poll();
                q.add(0);
            } else {
                q.add(q.poll());
            }
            pointer = (pointer + 1) % length;
        }
        
        answer = length - priority;
        return answer;
    }
}