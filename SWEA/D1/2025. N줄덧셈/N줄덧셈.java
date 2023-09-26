import java.util.Scanner;

public class Solution {
	
	public static int nSum(int n) {
		
		if(n==1) {
			return 1;
		}
		
		return n+nSum(n-1);
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
	
		System.out.println(nSum(N));
		
	}
}