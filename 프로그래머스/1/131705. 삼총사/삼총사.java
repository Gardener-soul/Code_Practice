import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int len = number.length;
        int[] com = new int[3];
        
        answer += comb(len, 0, 0, number, com);
        
        return answer;
    }
    
    public static int comb(int len, int idx, int sidx, int[] number, int[] com) {
        if (sidx == 3) {
            int chk = 0;
            for (int i = 0; i < 3; i++) {
                chk += com[i];
            }            
            if (chk == 0) return 1;
            else return 0;
        }
        
        int count = 0;
        for (int i = idx; i < len; i++) {
            com[sidx] = number[i];
            count+=comb(len, i + 1, sidx + 1, number, com);
        }
        return count;
    }
}
