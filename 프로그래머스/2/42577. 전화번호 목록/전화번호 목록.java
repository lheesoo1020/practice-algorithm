import java.util.*;
import java.lang.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        int length = phone_book.length;
        
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < length; i++) {
            list.add(phone_book[i]);
        }
        Collections.sort(list);
        
        String tmp1;
        String tmp2;
        
        for (int i = 0; i < length - 1; i++) {
            tmp1 = list.get(i);
            tmp2 = list.get(i + 1);
            if (tmp2.startsWith(tmp1)) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}