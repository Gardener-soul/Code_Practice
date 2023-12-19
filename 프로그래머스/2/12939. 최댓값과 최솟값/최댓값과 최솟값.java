import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            if(min>=Integer.parseInt(nums[i])) min = Integer.parseInt(nums[i]);
            if(max<=Integer.parseInt(nums[i])) max = Integer.parseInt(nums[i]);
        }
        answer+=String.valueOf(min+ " ");
        answer+=String.valueOf(max);
        return answer;
    }
}