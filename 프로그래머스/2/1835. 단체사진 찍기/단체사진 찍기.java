import java.util.*;

class Solution {
    
    static int ans;
    static boolean flag;
    static int[] res, num;
    static boolean[] chk;
    static HashMap<Character,Integer> map;
    
    public static void perm(int n, String[] data, int idx){
        
        if(idx==8){
            check(n, data);
            if(flag) ans++;
            return;
        }
        
        for(int i=0; i<8; i++){
            if(chk[i]) continue;
            
            chk[i] = true;
            res[idx] = num[i];
            perm(n, data, idx+1);
            chk[i] = false;
        }
    }
    
    public static void check(int n, String[] data) {
        
        for(int i=0; i<n; i++){
            flag = false;
            
            String tmp = data[i];
            char a = tmp.charAt(0);
            char b = tmp.charAt(2);
            int c = tmp.charAt(4)-'0';
            
            if (tmp.charAt(3)=='='){
                if(Math.abs(res[map.get(a)]-res[map.get(b)])==c+1){
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            } else if (tmp.charAt(3)=='>'){
                if(Math.abs(res[map.get(a)]-res[map.get(b)])>c+1){
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            } else if (tmp.charAt(3)=='<'){
                if(Math.abs(res[map.get(a)]-res[map.get(b)])<c+1){
                    flag = true;
                } else {
                    flag = false;
                    break;
                } 
            }
            
        }
        
    }
    
    public int solution(int n, String[] data) {
        ans = 0;
        res = new int[8];
        num = new int[8];
        chk = new boolean[8];
        
        for(int i=0; i<8; i++){
            res[i] = i;
            num[i] = i;
        }
        
        map = new HashMap<>();
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        
        perm(n, data, 0);
        
        return ans;
    }
}