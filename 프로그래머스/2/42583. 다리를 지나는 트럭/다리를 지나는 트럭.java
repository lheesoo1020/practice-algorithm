import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> trucks = new LinkedList<>();
        for (int t : truck_weights) {
            trucks.add(t);
        }
        
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length - 1; i++) {
            bridge.add(0);
        }
        
        int w = 0;
        int tmp = 0;
        int answer = 0;
        
        answer++;
        tmp = trucks.poll();
        bridge.add(tmp);
        w += tmp;
        
        while(w != 0) {
            answer++;
            w -= bridge.poll();
            
            if (!trucks.isEmpty() && w + trucks.peek() <= weight) {
                tmp = trucks.poll();
                bridge.add(tmp);
                w += tmp;
            } else {
                bridge.add(0);
            }    
        }
        
        return answer;
    }
}