import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int num=0;
		
		for(int t=1; t<=T; t++) {
			int ch = 0;
			
			int n = sc.nextInt();
			int[] nArr = new int[n];
			for(int i=0; i<n; i++) {
				int block = sc.nextInt();
				nArr[i]=block; //블록 배열 생성.
			}
			
			for(int j=0; j<n-2; j++) {
				for(int k=1; k<n-1; k++) {
					if(nArr[k-1] > nArr[k]) {
						int tmp = nArr[k];
						nArr[k] = nArr[k-1];
						nArr[k-1] = tmp;
						ch++;
						break;
					} 
				}
			}
			num++;
			System.out.println("#" + num + " " + ch);
		}
	}
}
