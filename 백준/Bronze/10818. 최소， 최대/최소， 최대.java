import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int[] arr = new int[t];
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			arr[i]+=n;
		}
		Arrays.sort(arr);
		
		System.out.println(arr[0]+" "+ arr[t-1]);
	}
}