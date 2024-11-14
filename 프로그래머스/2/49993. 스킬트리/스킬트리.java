import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0; i<skill_trees.length; i++) {
            boolean flag = true;
            
            int[] chk = new int[26]; // A: 17 ~  Z: 42
            char[] al = new char[26];
            
            int idx = 1;
            for(int a=0; a<skill.length(); a++) {
                chk[skill.charAt(a)-'0'-17]=idx++;
            
                if(a!=skill.length()-1) al[skill.charAt(a)-'0'-17] = skill.charAt(a+1);
            }
            
            for(int j=0; j<skill_trees[i].length(); j++) {
                char tmp = skill_trees[i].charAt(j);
                
                if(chk[tmp-'0'-17]==1) {
                    
                    for(int b=0; b<26; b++) {
                        if(chk[b]>=1) chk[b]--;
                    }
                    
                } else if (chk[tmp-'0'-17]>1) {
                    flag = false;
                    break;
                }
                
            }
            
            if(flag) answer+=1;
            
        }
        
        return answer;
    }
}