/*
1. 1,2,3,4,5
2. 2,1,2,3,2,4,2,5
3. 3,3,1,1,2,2,4,4,5,5
*/

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] one = {1,2,3,4,5}; //5
        int[] two = {2,1,2,3,2,4,2,5}; //8
        int[] three = {3,3,1,1,2,2,4,4,5,5}; //10
        int o = 0 , tw = 0, th=0, max=-1;
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%5]) o++;
            if(answers[i] == two[i%8]) tw++;
            if(answers[i] == three[i%10]) th++;
        }
        
        max = Math.max(o, Math.max(tw, th));

        if(max==o) arr.add(1);
        if(max==tw) arr.add(2);
        if(max==th) arr.add(3);
        
        int[] answer = new int[arr.size()];
        
        for(int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}