import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] arr = new int[n+1];
        Arrays.fill(arr,1);
        
        System.out.println(Arrays.toString(arr));
        
        for(int i=0; i<lost.length; i++){
            arr[lost[i]]--;
        }

        for(int i=0; i<reserve.length; i++){
            arr[reserve[i]]++;
        }
        
        for(int i=1; i<arr.length; i++){
            if(arr[i]==0){
                if(arr[i-1]>1) {
                    arr[i-1]--;
                    arr[i]++;
                } else if (i<arr.length-1 && arr[i+1]>1) {
                    arr[i+1]--;
                    arr[i]++;
                }
            }
        }
        
        for(int i=1; i<arr.length; i++){
            if(arr[i]>0) answer++;
        }
        
        return answer;
    }
}