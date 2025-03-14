import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        int length = numbers.length();
        Set<Integer> nums = new HashSet<>();
        boolean[] visited = new boolean[length];
        
        recursive(nums, numbers, "", visited);
        for (int num : nums) {
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public void recursive(Set<Integer> nums, String numbers, String currentNum, boolean[] visited) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                String newCurrentNum = currentNum + String.valueOf(numbers.charAt(i));
                nums.add(Integer.parseInt(newCurrentNum));
                recursive(nums, numbers, newCurrentNum, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        if (num == 2) return true;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}