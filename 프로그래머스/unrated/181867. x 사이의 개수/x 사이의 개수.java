import java.util.*;

class Solution {
    public List<Integer> solution(String myString) {
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;
        for(int i=0; i<myString.length(); i++){
            if(myString.charAt(i)!='x'){
                cnt++;
            } else if (myString.charAt(i)=='x'){
                answer.add(cnt);
                cnt = 0;
            }
        }
        answer.add(cnt);
        return answer;
    }
}