import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase <=T; testCase++) {
			String str = scanner.next();
			
			int[] S = new int[14];
			int[] D = new int[14];
			int[] H = new int[14];
			int[] C = new int[14];
			
			Arrays.fill(S, 1);
			Arrays.fill(D, 1);
			Arrays.fill(H, 1);
			Arrays.fill(C, 1);
			
			char f = 0;
			int num = 0;
			
			for(int i=0; i<str.length(); i=i+3) {
				f = str.charAt(i);
				num = (str.charAt(i+1)-'0')*10 + str.charAt(i+2)-'0';
				
				if(f=='S') {
					S[num]--;
				} else if(f=='D') {
					D[num]--;
				} else if(f=='H') {
					H[num]--;
				} else if(f=='C') {
					C[num]--;
				}
			}
			
			int Scnt = 0;
			int Dcnt = 0;
			int Hcnt = 0;
			int Ccnt = 0;
			
			for(int i=1; i<14; i++) {

				if(S[i]==1) {
					Scnt++;
				}
				if(D[i]==1) {
					Dcnt++;
				}
				if(H[i]==1) {
					Hcnt++;
				}
				if(C[i]==1) {
					Ccnt++;
				}

			}
			
			boolean flag = true;
			for(int i=1; i<14; i++) {
				if(S[i] <= -1 || D[i] <= -1 || H[i] <= -1 || C[i] <= -1) {
					flag = false;
					System.out.println("#" + testCase + " " + "ERROR");
					break;
				}
			}
			
			if(flag!=false) {
				System.out.println("#" + testCase + " " + Scnt + " " + Dcnt + " " + Hcnt + " " +Ccnt);
			}
			
		} //tc
	}
}