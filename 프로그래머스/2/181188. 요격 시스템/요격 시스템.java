import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1,o2) -> o1[1] - o2[1]);
        
        answer++;
        int tmp = targets[0][1];
        for(int i=0; i<targets.length; i++){
            if(tmp<=targets[i][0]) {
                tmp=targets[i][1];
                answer++;
            }
            
        }
        
        // System.out.println(Arrays.deepToString(targets));
        return answer;
    }
}