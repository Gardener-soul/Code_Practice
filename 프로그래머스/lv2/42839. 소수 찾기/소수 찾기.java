import java.util.HashSet;
import java.util.Iterator;

class Solution {
    
    static String[] arr;
    static String[] res;
    static boolean[] chk;
    static boolean[] chk2;
    static int cnt;
    static int N;
    static HashSet<Integer> set;
    
    public static void perm(int idx) {
        
          if(idx == N){
                
              	String s="";
                for(int i=0; i<N; i++){
                    if(chk2[i]){
                     
                        s+=res[i];
                     
                    }
                }

                if(s.equals("")) {
                	s="0";
                }
                int ns=Integer.parseInt(s);
                set.add(ns);
                
                return;
            }
            
          	chk2[idx] = true;
            perm(idx + 1);
            
            chk2[idx] = false;
            perm(idx + 1);
        
    }
    
    private static void permutation(int cnt) {
        if (cnt == N) {
        	perm(0);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!chk[i]) {
                chk[i] = true;
                res[cnt] = arr[i];
                permutation(cnt + 1);
                chk[i] = false;
            }
        }
    }
    
    public static boolean isSosu(int num){

        if(num<2){
            return false;
        } else if (num==2){
            return true;
        }
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            } 
        }
        
        return true;
        
    }    
    
    public int solution(String numbers) {
        arr = numbers.split(""); // 입력받는 숫자들을 String 배열로 넣음
        N = arr.length; // arr의 길이
        chk = new boolean[N]; // 순열을 체크하는 TF 배열
        chk2 = new boolean[N]; // 조합을 체크하는 TF 배열
        res = new String[N]; // 순열의 결과를 담는 배열 - 추후 이 배열을 기반으로 조합에 사용됨.
        set = new HashSet<Integer>();
        cnt = 0;
        
        permutation(0);
        
        Iterator<Integer> res = set.iterator();
        
        for(int i=0; i<set.size(); i++) {
        	int a1 = res.next();
        	if(isSosu(a1)) {
        		cnt++;
        	}
        }
        return cnt;
    }
}
