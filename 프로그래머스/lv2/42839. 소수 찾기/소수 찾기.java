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
    
    public static void powerset(int idx) { // 조합을 구하는 메소드
        
          if(idx == N){ // idx가 N에 도달했을 때 (모든 chk배열이 확인됨) 이 부분에서 조합이 완료됨.
                
              	String s=""; // s를 하나 선언.
                for(int i=0; i<N; i++){
                    if(chk2[i]){
                     
                        s+=res[i]; // chk2[i]가 true인 부분의 인덱스만큼 s 결과에 담을 것임.
                     
                    }
                }

                if(s.equals("")) { // s가 빈값으로 담겨오는 경우도 있었음 모든 chk2[i]가 True일 때, 이 때는 숫자로 변환이 안됐음. 그래서 강제로 0으로 치환함.
                	s="0";
                }
                int ns=Integer.parseInt(s); // s를 숫자로 바꿈. 이렇게 하면 앞의 0들이 다 떼어짐.
                set.add(ns); // 이런 숫자들을 다 set 자료구조에 넣음. 이러면 중복된 것은 안들어감.
                
                return;
            }
            
          	chk2[idx] = true;
            perm(idx + 1);
            
            chk2[idx] = false;
            perm(idx + 1);
        
    }
    
    private static void permutation(int cnt) { // 순열을 구하는 메소드.
        if (cnt == N) {
        	powerset(0); // 하나의 순열이 완성될 때마다 조합을 구하고자 했음.
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
    
    public static boolean isSosu(int num){ // 소수를 구하는 메소드

        if(num<2){ // 2보다 작은 숫자가 들어오면 소수가 아니다.
            return false;
        } else if (num==2){ // 2는 소수다.
            return true;
        }
        
        for(int i=2; i<=Math.sqrt(num); i++){ // 아라토스테네스의 체? 알고리즘. 입력받는 숫자의 제곱근보다 크거나 작게. i는 무조건 2보다 크게!!
            if(num%i==0){ // 이 과정에서 num을 i로 나눴을 때 0이라면 이건 소수임. 
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
        set = new HashSet<Integer>(); // 문자열로 받고, 숫자로 변환시 중복된 숫자가 많이 나올 수 있기 때문에 Set 자료구조를 사용함.
        cnt = 0; // 소수의 개수를 담는 변수.
        
        permutation(0); //시작!!
        
        Iterator<Integer> res = set.iterator(); // set에 담긴 변수들을 출력하기 위해 Iterator 클래스 선언.
        
        for(int i=0; i<set.size(); i++) { // set의 담긴 size만큼 반복문을 수행. set에는 중복되지 않은 숫자들이 들어있음.
        	int a1 = res.next(); // res.next() 메소드로, set에 담긴 변수들을 빼올 수 있음.
        	if(isSosu(a1)) { 
        		cnt++;
        	}
        }
        return cnt;
    }
}

중요!! 
1. 소수를 구하는 아라토스테네스의 체 알고리즘은 외워야할 것!
2. 조합과 순열 + 부분집합까지 구하는 알고리즘은 외워야할 것!
 
