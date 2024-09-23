import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=1; i<=score.length; i++) {
            arr.add(score[i-1]);
            Collections.sort(arr, Collections.reverseOrder());
            if(arr.size()<k) answer[i-1] = arr.get(i-1);
            else answer[i-1] = arr.get(k-1);
        }
        
        return answer;
    }
}