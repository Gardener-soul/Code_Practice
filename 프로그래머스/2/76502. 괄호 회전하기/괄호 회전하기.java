import java.util.*;
import java.io.*;

class Solution {
    public boolean chk(Queue<Character> q, int len) {
        Stack<Character> sta = new Stack<>();
        for(int i=0; i<len; i++) {
            char tmp = q.poll();
            if(tmp=='(' || tmp=='{' || tmp=='[') sta.add(tmp);
            if(sta.isEmpty() && (tmp==']' || tmp=='}' || tmp==')')) return false;
            if(!sta.isEmpty()) {
                if(tmp==']' && sta.peek()=='[') sta.pop();
                else if (tmp=='}' && sta.peek()=='{') sta.pop();
                else if (tmp==')' && sta.peek()=='(') sta.pop();
            }
            
        }
        if(sta.isEmpty()) return true;
        else return false;
    }
    
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        Queue<Character> orQ = new LinkedList<>();
        for(int i=0; i<len; i++) {
            orQ.offer(s.charAt(i));
        }
        
        for(int i=0; i<len; i++) {
            int tmp = 0;
            Queue<Character> subQ = new LinkedList<>(orQ);
            while(i!=tmp) {
                char cTmp = subQ.poll();
                subQ.offer(cTmp);
                tmp++;
            }
            if(chk(subQ, len)) answer++;
        }
        
        return answer;
    }
}