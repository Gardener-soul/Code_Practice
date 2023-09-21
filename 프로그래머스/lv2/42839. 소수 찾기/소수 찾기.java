import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class Solution {
    
    static String[] arr;
    static List<String> sarr;
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
                        // 이 부분에서 부분 조합 모두가 다 결정.
                     
                        s+=res[i];
//                        System.out.print(arr[i]+ " ");
                     
                    }
                }

                if(s.equals("")) {
                	s="0";
                }
                int ns=Integer.parseInt(s);
                set.add(ns);
                
//                System.out.println(Integer.parseInt(s));
//                System.out.println();
//                System.out.println(set);
//                isSosu(s);
                
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
        arr = numbers.split("");
        sarr = new ArrayList<>();
        N = arr.length;
        chk = new boolean[N];
        chk2 = new boolean[N];
        set = new HashSet<Integer>();
        cnt = 0;
        res = new String[N];
        
        for(int i=0; i<N; i++) {
        	sarr.add(arr[i]);
        }

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