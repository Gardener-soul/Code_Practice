import java.util.*;
import java.io.*;

/*
1. 최소 필요 피로도와 소모피로도가 있음.
2. 입력 k, dungeons[i][0] = 최소 필요 피로도 , dungeons[i][1] = 소모 피로도
3. 들어갈 수 있는 최대의 던전 구하셈요. 
*/

class Solution {
    
    public int answer, len;
    public boolean[] chk;
    
    public void dfs(int level, int k, int[][] dungeons){
        
        for(int i=0; i<len; i++){
            if(!chk[i] && dungeons[i][0]<=k){
                chk[i] = true;
                dfs(level+1, k-dungeons[i][1], dungeons);
                chk[i] = false;
            }
        }
        answer = Math.max(answer, level);
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        len = dungeons.length;
        chk = new boolean[len];
        
        dfs(0, k, dungeons);
        
        return answer;
    }
}