import java.util.*;

class Solution {
    
    static int answer;
    static int[] list;
    static boolean[] chk;
    static HashMap<Character,Integer> map;
    
    public static void perm(int idx, int n, String[] data){
        if(idx == 8){
            if(chk(n, data)){
                answer++;
            }
            return;
        }
        
        for(int i=0; i<8; i++){
            if(chk[i]) continue;
            chk[i] = true;
            list[idx] = i;
            perm(idx+1, n , data);
            chk[i] = false;
        }   
        
    }
    
    public int solution(int n, String[] data) {
        answer = 0;
        
        // 캐릭터들의 정보를 map에 담아 순열을 돌릴거임.
        map = new HashMap<Character,Integer>();
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        
        list = new int[8]; // 결과를 담을 배열
        chk = new boolean[8];
        
        perm(0, n, data);
        
        return answer;
    }
    
   public static boolean chk(int n , String[] data){
       
       for(int i=0; i<n; i++){
           
           int A = list[map.get(data[i].charAt(0))];
           int B = list[map.get(data[i].charAt(2))];
           char giho = data[i].charAt(3);
           int num = data[i].charAt(4) - '0'+1;
           
           int dist = Math.abs(A-B);
           
           if(giho=='='){
               if(dist!=num) {
                   return false;
               }
           } else if(giho=='>'){
               if(dist<=num) {
                   return false;
               }
           } else if (giho=='<'){
               if(dist>=num) {
                   return false;
               }
           }
       }
      return true;
   } 
    
}