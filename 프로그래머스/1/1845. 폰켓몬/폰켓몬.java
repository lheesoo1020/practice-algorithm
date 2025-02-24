import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        int length = nums.length;
        
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }
        
        answer = set.size();
        if (set.size() > length/2) {
            answer = length/2;
        }
        
        return answer;
    }
}