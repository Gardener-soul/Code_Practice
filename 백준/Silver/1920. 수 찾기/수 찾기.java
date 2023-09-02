import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = scanner.nextInt();
		}
		
		Arrays.sort(arr);
		
		int M = scanner.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			if(binarySearch(arr,scanner.nextInt())>=0) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	} //main
	
	public static int binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length-1;
		
		while(left<=right) {
			
			int mid = (left + right) / 2;
			
			if(key<arr[mid]) {
				right = mid-1;
			}

			else if (key > arr[mid]) {
				left = mid + 1;
			}
			
			else {
				return mid;
			}
			
		}
		
		return -1;
		
	}
	
}
