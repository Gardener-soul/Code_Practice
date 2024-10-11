import java.util.*;

class Solution {
    static int answer;
    static boolean[] chk;
    
    public static void perm(int[] numbers,boolean[] chk, int idx, int target) {
        if(idx == numbers.length) {
            int tmp = 0;
            
            for(int i=0; i<numbers.length; i++) {
                if(chk[i]) tmp+=numbers[i];
                else tmp-=numbers[i];
            }
            
            
            if(tmp==target) answer++;
            return;
        }
        
        chk[idx] = false;
        perm(numbers, chk, idx+1, target);
        chk[idx] = true;
        perm(numbers, chk, idx+1, target);
        
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        chk = new boolean[numbers.length];
        perm(numbers,chk, 0, target);
        return answer;
    }
}