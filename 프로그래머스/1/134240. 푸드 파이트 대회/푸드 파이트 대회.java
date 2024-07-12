import java.util.*;

class Solution {
    public String solution(int[] food) {
        
        StringBuilder answer = new StringBuilder();
        int len = 0;
        for(int i=1; i<food.length; i++) {
            len += food[i]/2;
        }
        
        int[] arr = new int[len];
        int tmp = 0;
        for (int i=1; i<food.length; i++) {
            for(int j=0; j<food[i]/2; j++) {
                arr[tmp++] = i;
            }
        }
        
        for(int i=0; i<arr.length; i++) {
            answer.append(Integer.toString(arr[i]));
        }
        answer.append("0");
        
        for(int i=arr.length-1; i>=0; i--){
            answer.append(Integer.toString(arr[i]));
        }
        
        return answer.toString();
    }
}