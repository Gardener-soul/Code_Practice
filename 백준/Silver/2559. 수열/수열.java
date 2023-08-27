import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); //배열의 크기
		int K = scanner.nextInt(); //확인해야 할 날짜.
		int[] tem = new int[N];
		
        for(int i=0; i<N; i++) {
			tem[i] = scanner.nextInt();
		}
		
		int max = -1000000000;
		for(int i=0; i<=N-K; i++) {
			int sum=0;
			for(int j=i; j<i+K; j++) {
				sum+=tem[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}