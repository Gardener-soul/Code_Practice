import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        
       for(int i=0; i<arr.length; i++){
           int n = delete_list.length;
             for(int j=0; j<delete_list.length; j++){
                if(arr[i]==delete_list[j]){
                    n--;
                }
            }
           if(n==delete_list.length) answer.add(arr[i]);
        }
        return answer;
    }
}