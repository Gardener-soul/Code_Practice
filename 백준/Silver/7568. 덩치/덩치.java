import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] dung = new int[N][2];
		for(int i=0; i<N; i++) {
			dung[i][0] = scanner.nextInt();
			dung[i][1] = scanner.nextInt();
		}
		for(int i=0; i<N; i++) {
			int rank = 1;
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(dung[i][0]<dung[j][0] && dung[i][1]<dung[j][1]) {
					rank++;
				}
				
			}
			System.out.print(rank + " ");
		}
	}
}