import java.util.Scanner;

public class Main {
	
	static int N,M;
	static int[] arr;
	static int[] res;
	static boolean[] chk;
	static StringBuilder sb = new StringBuilder();
	
	public static void perm(int level) {
		
		if(level == M) {
			
			for(int i=0; i<M; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			chk[i] = true;
			res[level] = arr[i];
			perm(level+1);
			chk[i] = false;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt(); // 숫자의 개수
		M = scanner.nextInt(); // 몇개 뽑을건지
		
		arr = new int[N];
		res = new int[M];
		chk = new boolean[N];
		int cnt = 1;
		
		for(int i=0; i<N; i++) {
			arr[i] = cnt++;
		}
		
		perm(0);
		System.out.println(sb);
	}
}