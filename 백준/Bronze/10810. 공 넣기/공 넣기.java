import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] ans = new int[N];
		int M = scanner.nextInt();
		for(int tM=0; tM<M; tM++) {
			int i = scanner.nextInt(); //인덱스 i-1부터 j-1까지
			int j = scanner.nextInt(); 
			int k = scanner.nextInt(); //이 값 넣기
			
			for(int a=i-1; a<j; a++) {
				ans[a]=k;
			}		
		}
		for(int i=0; i<N; i++) {
			System.out.print(ans[i] +" ");
		}
	}	
}