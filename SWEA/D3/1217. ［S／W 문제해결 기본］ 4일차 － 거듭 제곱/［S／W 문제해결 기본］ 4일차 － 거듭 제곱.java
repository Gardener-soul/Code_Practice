import java.util.Scanner;

public class Solution {

	static int N;
	static int cnt;
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		for(int testCase=1; testCase<=10; testCase++) {
		
			scanner.nextInt(); //숫자하나 받기
			N = scanner.nextInt();
			cnt = scanner.nextInt();
			
			System.out.println("#" + testCase + " "+ pow(N,cnt));
			
		}
		
	}
	
	static int pow(int N,int cnt) {
		if(cnt==0) return 1;
		
		return N*pow(N,cnt-1);
		
	}
	
}