import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> sta = new Stack<>();
        sta.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i]==sta.peek()) continue;
            else sta.add(arr[i]);
        }    
        
        int[] answer = new int[sta.size()];
        for(int i=sta.size()-1; i>=0; i--){
            answer[i] = sta.peek();
            sta.pop();
        }    
        return answer;
    }
}