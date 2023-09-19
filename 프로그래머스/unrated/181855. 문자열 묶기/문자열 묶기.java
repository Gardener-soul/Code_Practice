import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        
        int[] cnt = new int [31];
        
        for(int i=0; i<strArr.length; i++){
            answer = strArr[i].length();
            cnt[answer]++;
        }
        Arrays.sort(cnt);
        answer = cnt[30];
        return answer;
    }
}