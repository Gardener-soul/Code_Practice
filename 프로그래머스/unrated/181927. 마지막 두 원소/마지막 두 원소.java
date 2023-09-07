import java.util.*;

class Solution {
    public List<Integer> solution(int[] num_list) {
        List<Integer> num = new ArrayList<>();
        int n = num_list.length;
        for(int i=0; i<n; i++){
            num.add(num_list[i]);
        }
        if(num_list[n-1]>num_list[n-2]){
            num.add(num_list[n-1] - num_list[n-2]);
        } else{
            num.add(num_list[n-1] *2);
        }
        
        return num;
    }
}