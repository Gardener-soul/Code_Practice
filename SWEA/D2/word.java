import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] word = new int[N][N];
             
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    word[i][j]=sc.nextInt();
                }
            } //word 배열 생성 완료
             
            List<Integer> sum = new ArrayList<>(); //arrayList로 받을거임
             
            for(int i=0; i<N; i++) {
                int cnt=0;
                for(int j=0; j<N; j++) {
                     
                    if(word[i][j]==1) {
                        cnt++;
                        }
                    if(word[i][j]==0||j==N-1) {
                        sum.add(cnt);
                        cnt=0;
                    }
                }
            }
             
            //열 확인
            for(int j=0; j<N; j++) {
                int cnt=0;
                for(int i=0; i<N; i++) {
                     
                    if(word[i][j]==1) {
                        cnt++;
                        }
                    if(word[i][j]==0||i==N-1) {
                        sum.add(cnt);
                        cnt=0;
                    }
                }
            }
            int ans = 0;
            for(int i=0; i<sum.size(); i++) {
                if(K==sum.get(i)) {
                    ans++;
                }
            }
            System.out.println("#" + testCase + " " + ans);
        } // tc 반복문
    } //main 반복문    
}
