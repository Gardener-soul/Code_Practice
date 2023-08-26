import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); //라운드 수
		scanner.nextLine(); // 개행 하나 받기
		char[][] A = new char[N][];
		char[][] B = new char[N][];
		
		for(int i=0; i<N; i++) {
			A[i] = scanner.nextLine().toCharArray();
			B[i] = scanner.nextLine().toCharArray();
		}
		
		char ans = 0;
		
		for(int i=0; i<N; i++) {
			
			int[] cntA = new int[4];
			int[] cntB = new int[4];

			for(int j=1; j<A[i].length; j++) {

				if(A[i][j]=='4') {
					cntA[0]++;
				} else if(A[i][j]=='3') {
					cntA[1]++;
				} else if(A[i][j]=='2') {
					cntA[2]++;
				} else if(A[i][j]=='1') {
					cntA[3]++;
				} 
			}
			
			for(int j=1; j<B[i].length; j++) {
				if(B[i][j]=='4') {
					cntB[0]++;
				} else if(B[i][j]=='3') {
					cntB[1]++;
				} else if(B[i][j]=='2') {
					cntB[2]++;
				} else if(B[i][j]=='1') {
					cntB[3]++;
				} 
			}
			
			if(cntA[0]>cntB[0]) {
				ans = 'A';
			} else if (cntA[0]<cntB[0]) {
				ans = 'B';
			}
			
			if(cntA[0]==cntB[0]) {
				if(cntA[1]>cntB[1]) {
					ans = 'A';
				} else if (cntA[1]<cntB[1]) {
					ans = 'B';
				}
			}
			
			if(cntA[0]==cntB[0]&&cntA[1]==cntB[1]) {
				if(cntA[2]>cntB[2]) {
					ans = 'A';
				} else if (cntA[2]<cntB[2]) {
					ans = 'B';
				}
			}
			if(cntA[0]==cntB[0]&&cntA[1]==cntB[1]&&cntA[2]==cntB[2]) {
				if(cntA[3]>cntB[3]) {
					ans = 'A';
				} else if (cntA[3]<cntB[3]) {
					ans = 'B';
				}
			}
			if(cntA[0]==cntB[0]&&cntA[1]==cntB[1]&&cntA[2]==cntB[2]&&cntA[3]==cntB[3]) {
				ans = 'D';
			}
			System.out.println(ans);
		}

	} //main
}