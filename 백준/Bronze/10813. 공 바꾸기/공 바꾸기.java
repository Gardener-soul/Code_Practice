import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] ans = new int[N];
		for(int i=0; i<N; i++) {
			ans[i] = i+1;
		} // ans배열에 값 입력
        
		int M = scanner.nextInt();
		for(int tm = 0; tm<M; tm++) {
			
			int i = scanner.nextInt(); //i랑 j를 바꿀거임 ㅇㅇ
			int j = scanner.nextInt();
			
			int tmp = 0;
			tmp = ans[i-1];
			ans[i-1] = ans[j-1];
			ans[j-1] = tmp;
		}
		for(int i=0; i<N; i++) {
			System.out.print(ans[i] + " ");
		}
	}	
}