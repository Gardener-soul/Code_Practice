import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2]; // 몇 번째 사람, 몇 번째 말한거?
        HashSet<String> set = new HashSet<>();
        
        int i;
        boolean flag = true;
        for(i=0; i<words.length; i++) {
            
            char end = words[i].charAt(words[i].length()-1);
            char sta =' ';
            if(i+1<words.length) {
                sta = words[i+1].charAt(0);
            }
        
            if(set.contains(words[i])) {
                flag = false;
                answer[0] = (i%n)+1;
                answer[1] = i/n +1;
                break;
            }
            else set.add(words[i]);
            
            if(sta!=end && i+1<words.length) {
                i+=1;
                flag = false;
                answer[0] = (i%n)+1;
                answer[1] = i/n+1;
                break;        
            }
        }
        
        if(flag) Arrays.fill(answer,0);
        
        return answer;
    }
}