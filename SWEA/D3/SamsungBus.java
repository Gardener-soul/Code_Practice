import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			int N = scanner.nextInt();
			int[] A = new int[N];
			int[] B = new int[N];
			for(int nt = 0; nt<N; nt++) { //n개의 testcase
				A[nt] = scanner.nextInt();
				B[nt] = scanner.nextInt();
			}
			int P = scanner.nextInt(); //정류장 개수
			int[] C = new int[P];
			for(int i=0; i<P; i++) {
				C[i] = scanner.nextInt(); //정류장 번호 입력
			}
			int[] ans = new int[P]; //답 배열
			
			//1~3 / 2~5 하나씩 더하기
			//a1 ~ b1 / a2 ~ b2
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < P; ++j) {
					if (C[j] >= A[i] && C[j] <= B[i]) {
						ans[j]++;
					}
				}
			}
			
			System.out.print("#"+testCase);
			for(int i=0; i<P; i++) {
				System.out.print(" "+ans[i]);
			}
			System.out.println(); //테케가 하나밖에 존재하지 않아서, 이 한칸씩 띄워놓는 테크닉을 까먹었다. 주의!
		}
	} 	
}
