import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        int[] left = new int[len];
        int[] right = new int[len];
        
        for(int i=0; i<len; i++) {
            setA.add(topping[i]);
            left[i] = setA.size();
        }
        
        for(int i=len-1; i>=0; i--) {
            setB.add(topping[i]);
            right[i] = setB.size();
        }
        
        for(int i=0; i<len-1; i++) {
            if(left[i] == right[i+1]) answer++;
        }
        
        return answer;
    }
}