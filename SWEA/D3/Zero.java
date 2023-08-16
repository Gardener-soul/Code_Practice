import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            Stack<Integer> nums = new Stack<>();
            int ans = 0;
            int K = scanner.nextInt(); // nums의 개수
             
            for(int i=0; i<K; i++) {
                int num = scanner.nextInt();
                 
                if(num!=0) {
                    nums.push(num);
                } else if (num==0) {
                    nums.pop();
                }       
            } //stack 잘 들어감.
         
            while(!(nums.isEmpty())) {
                ans+=nums.pop();
            }
            System.out.println("#" + testCase + " " + ans);
        }   
    }   
}
