import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum=1;
		if(N>=1||N<=12) {
			while(N>1) {
				sum=sum*N;
				N=N-1;
			}
			System.out.println(sum);
		} else if(N==0) {
			System.out.println(1);
		}
		
}
}