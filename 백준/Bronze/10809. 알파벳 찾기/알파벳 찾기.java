import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		
		for(int i=0; i<str.length(); i++) {
			char s = str.charAt(i);
			
			if(arr[s-'a']==-1) {
				arr[s-'a'] =i;
			}
		}

		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");			
		}
	}
}
