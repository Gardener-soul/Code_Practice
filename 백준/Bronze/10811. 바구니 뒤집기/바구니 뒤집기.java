import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] ans = new int[N+1];
		for(int i=1; i<=N; i++) {
			ans[i] = i;
		} // ans배열에 값 입력
		int M = scanner.nextInt();
		for(int tm = 0; tm<M; tm++) {
			
			int i = scanner.nextInt(); //j에서 i로
			int j = scanner.nextInt();
			
			for(int a=i; a<=j; a++) {
				int nn = j--;
				
				int tmp = ans[a];
				ans[a] = ans[nn];
				ans[nn] = tmp;
			}		
		}
		for(int i=1; i<=N; i++) {
			System.out.print(ans[i] + " ");
		}
	}	
}