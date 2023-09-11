import java.util.*;

class Solution {
    public List<String> solution(String my_string) {
        List<String> answer = new ArrayList<>();
        String[] s = my_string.split(" ");
        
        for(int i=0; i<s.length; i++){
            if(!s[i].equals("")) answer.add(s[i]);
        }
        return answer;
    }
}