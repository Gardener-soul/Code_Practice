import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[T];
		
		for(int i=0; i<T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
		
			int sum = a+b;
			
			arr[i]+=sum;
		}
		
		for(int a : arr) {
			System.out.println(a);
		}	
}
}