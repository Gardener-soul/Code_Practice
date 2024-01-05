import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int n = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0) n++;
        }
        
        if(n==0){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            int[] answer = new int[n];
            int a = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]%divisor==0){
                    answer[a] = arr[i];
                    a++;
                }
            }
            Arrays.sort(answer);
            return answer;
        }

    }
}