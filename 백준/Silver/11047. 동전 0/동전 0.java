import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 가지고 있는 화폐 개수
		int mon = scanner.nextInt(); // 돈
		int[] num = new int[N];
		
		for(int i=0; i<N; i++) {
			num[i] = scanner.nextInt();
		}
		
		int cnt = 0;
		
		while(mon!=0) {
			for(int i=N-1; i>=0; i--) {
				if(num[i]<=mon) {
					mon=mon-num[i];
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}