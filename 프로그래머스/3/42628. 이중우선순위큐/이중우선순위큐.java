import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        

        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a, b) -> b - a);
        
        for (String op : operations) {
            String[] o = op.split(" ");
            if (!pqMin.isEmpty() && o[0].equals("D")) {
                if (o[1].equals("1")) {
                    int t = pqMax.poll();
                    pqMin.remove(t);
                } else {
                    int t = pqMin.poll();
                    pqMax.remove(t);
                }
            }
            if (o[0].equals("I")) {
                pqMin.add(Integer.parseInt(o[1]));
                pqMax.add(Integer.parseInt(o[1]));
            }
        }
            
        int[] answer;
        
        if (pqMin.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            answer = new int[]{pqMax.poll(), pqMin.poll()};
        }
        
        return answer;
    }
}