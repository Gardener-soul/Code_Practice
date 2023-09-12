import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = scanner.nextInt(); // 사람의 배열.
		int[][] arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
		}
		
		
		for(int i=0; i<N; i++) {
			int rank = 1;
			
			for(int j=0; j<N; j++) {
				
				if(i==j) continue;			
				if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) {
					rank++;
				}
	
			}
			sb.append(rank + " ");
		}
		System.out.println(sb);
	}
}