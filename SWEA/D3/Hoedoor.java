import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        for(int testCase=1; testCase <= 10; testCase++) {
            int T = scanner.nextInt(); //걍 숫자 받는거
            String P = scanner.next(); // 작은 글
            String S = scanner.next(); // 긴 글
            int p = P.length();
            int s = S.length();
            int cnt = 0; //개수 세는 답
             
            for(int i=0; i<=s-p; i++) {
                boolean flag = true;
                for(int j=0; j<p; j++) {
                    if(P.charAt(j)!=S.charAt(i+j)) { 
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    cnt++;
                }
            }
            System.out.println("#" + testCase + " " + cnt);
        } // tc
    } // main
}

/* charAt(i+j)의 테크닉에 주목할 것.
*/
