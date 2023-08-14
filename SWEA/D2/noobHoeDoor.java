import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            String str = scanner.next();
            int ans = 0;
                for(int i=0; i<=str.length()/2-1; i++) {
                    if(str.charAt(i)==str.charAt(str.length()-i-1)){
                        ans = 1;
                } else {ans = 0;}
            } 
            if(str.length()==1) {
                ans = 1;
            }
            System.out.println("#" + testCase + " " + ans);
        }
    }
}
