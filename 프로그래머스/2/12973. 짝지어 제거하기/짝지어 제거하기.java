import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> sta = new Stack<>();
        sta.add(s.charAt(0));
        
        for(int i=1; i<s.length(); i++) {
            if(!sta.isEmpty()) {
                char tmp = sta.peek();
            
                if(s.charAt(i)==tmp) sta.pop();
                else sta.add(s.charAt(i));
            } else sta.add(s.charAt(i));
        }
        
        if(sta.size()>0) return 0;
        else return 1;
    }
}