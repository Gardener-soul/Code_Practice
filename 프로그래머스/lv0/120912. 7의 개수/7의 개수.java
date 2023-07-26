import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int i=0; i<array.length; i++){
            String sev = Integer.toString(array[i]);
            String[] seven = sev.split("");

            for(int j=0; j<seven.length; j++){
            if(seven[j].equals("7")){
                answer++;
        }
            }
        }

        return answer;
    }
}