import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] Arr = new int[N];
		for (int i = 0; i < N; i++) {
			Arr[i] = sc.nextInt();
		}
		
		int answer = 0;
		int cnt = 0;
		
		//N-1로 검사하기 때문에 N==1일때의 처리가 필요합니다.
		if(N==1) {
			System.out.println(1);
			System.exit(0);
		}
		
		//오름차순 검사
		for (int i = 0; i < N-1; i++) {
			if(Arr[i] <= Arr[i+1]) cnt++;
			if(Arr[i]> Arr[i+1]) {
				cnt++;
				answer = Math.max(answer, cnt);
				cnt = 0;
			}
			if(i == N-2) {
				cnt++;
				answer = Math.max(answer, cnt);
				cnt = 0;
			}
		}

		// 내림차순 검사
		for (int i = 0; i < N-1; i++) {
			if(Arr[i] >= Arr[i+1]) cnt++;
			if(Arr[i] < Arr[i+1]) {
				cnt++;
				answer = Math.max(answer, cnt);
				cnt = 0;
			}
			if(i == N-2) {
				cnt++;
				answer = Math.max(answer, cnt);
				cnt = 0;
			}
		}		
		System.out.println(answer);
	}
}