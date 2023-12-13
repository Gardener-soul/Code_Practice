import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> sta = new Stack<>();   
        sta.add(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp=='('||sta.size()==0){
                sta.add(tmp);
            } else{
                if(sta.peek()=='('){
                    sta.pop();
                } else {
                    sta.add(tmp);
                }
            }
        }
        
        if(sta.size()==0) answer=true;
        else answer=false;
        if(s.length()==1) answer=false;
        return answer;
    }
}