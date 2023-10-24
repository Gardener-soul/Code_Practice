import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] num, res;
	static boolean[] chk;
	static StringBuilder sb;
	
	public static void com(int idx, int sidx) {
		if(sidx==6) {
			for(int i=0;i<6; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		if(idx==N) return;
		res[sidx] = num[idx];
		com(idx+1, sidx+1);
		com(idx+1,sidx);
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			N = scanner.nextInt();
			if(N==0) break;
			
			num = new int[N];
			res = new int[6];
			chk = new boolean[N];
			
			sb = new StringBuilder();
			for(int i=0; i<N; i++) {
				num[i] = scanner.nextInt();
			}
			com(0,0);
			System.out.println(sb);
		}
		
	}
}