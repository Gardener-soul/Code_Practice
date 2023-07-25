import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        // int idx = 0;
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            // int value = -1;
            
            int min = Integer.MAX_VALUE;
            
            for (int j = s; j <= e; j++) {
                if (arr[j] > k && arr[j] < min) {
                    min = arr[j];
                    answer[i] = arr[j]; 
                } 
                if(min == Integer.MAX_VALUE){
                    answer[i] = -1;
                }
            }   
        }
        return answer;
    }
}