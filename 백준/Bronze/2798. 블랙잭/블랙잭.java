import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] result;
	static int[] arr;
	static int N,M,max;
	
	public static void com(int idx, int sidx) {
		
		if(sidx==3) {
			
			int sum = 0;
			
			for(int i=0; i<3; i++) {
				sum+=result[i];
			}
			
			if(sum<=M) {
				max = Math.max(max, sum);
			}
			return;
			
		}
		
		for(int i=idx; i<=N-3+sidx; i++) {
			result[sidx] = arr[i];
			com(i+1, sidx+1);
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt(); // 카드 개수
		M = scanner.nextInt(); // 나와야 하는 수
		result = new int[3];
		arr = new int[N];
		
		max = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = scanner.nextInt();
		}

		com(0,0);
		System.out.println(max);
	} //main
	
}