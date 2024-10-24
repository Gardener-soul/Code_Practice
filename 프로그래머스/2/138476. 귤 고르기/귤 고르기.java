import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        
        ArrayList<Map.Entry<Integer,Integer>> arr = new ArrayList<>(map.entrySet());
        arr.sort((a,b) -> b.getValue() - a.getValue());
        
        for(int i=0; i<arr.size(); i++) {
            if(k<=0) break;
            k-=arr.get(i).getValue();
            answer++;
        }
        
        return answer;
    }
}