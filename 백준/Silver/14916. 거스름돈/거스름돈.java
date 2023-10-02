import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		int[] ans = new int[100001];
		
		ans[1] = -1;
		ans[2] = 1;
		ans[3] = -1;
		ans[4] = 2;
		ans[5] = 1;
		
		for(int i = 6; i<ans.length; i++) {
			if(i%5==1) {
				ans[i] = 2 + (i/5);
			} else if(i%5==2) {
				ans[i] = 1 + (i/5);
			} else if(i%5==3) {
				ans[i] = 3 + (i/5);
			} else if(i%5==4) {
				ans[i] = 2 + (i/5);
			} else if(i%5==0) {
				ans[i] = 0 + (i/5);
			}
		}
		
		System.out.println(ans[N]);
		
	}
	
}