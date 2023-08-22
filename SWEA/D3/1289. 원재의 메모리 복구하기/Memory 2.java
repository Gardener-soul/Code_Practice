import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
             
            String N = scanner.next(); //메모리 입력
             
            char tmp = '0';
            int cnt = 0;
            for(int i=0; i<N.length(); i++) {
                if(tmp!=N.charAt(i)){
                    cnt++;
                    tmp = N.charAt(i);
                }
            }
            System.out.println("#" + testCase + " " + cnt);     
        } //tc
    }//main
}
