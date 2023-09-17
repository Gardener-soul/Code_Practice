import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); //사람 수
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = scanner.nextInt();
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				sum += arr[j];
			}
		}
		System.out.println(sum);
	}
}