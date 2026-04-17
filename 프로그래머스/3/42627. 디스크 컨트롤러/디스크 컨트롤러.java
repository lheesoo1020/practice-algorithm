import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        int time = 0;
        int answer = 0;
        
        List<int[]> jobList = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            jobList.add(jobs[i]);
        }
        jobList.sort((a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        while (true) {
            
            while (!jobList.isEmpty() && time >= jobList.get(0)[0]) {
                pq.add(jobList.remove(0));
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
            
                time += job[1];
                answer += (time - job[0]);    
            } else {
                time = jobList.get(0)[0];
            }
            
            if (jobList.isEmpty() && pq.isEmpty()) break;
        }
        
        return (int) (answer / jobs.length);
    }
}