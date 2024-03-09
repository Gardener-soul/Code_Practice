import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes,(o1,o2) -> o1[1] - o2[1]);
        
        int tmp = Integer.MIN_VALUE;
        for(int i=0; i<routes.length; i++){
            if(tmp<routes[i][0]){
                tmp = routes[i][1];
                answer++;
                // System.out.println(tmp);
            }
        }
        
        System.out.println(Arrays.deepToString(routes));        
        return answer;
    }
}