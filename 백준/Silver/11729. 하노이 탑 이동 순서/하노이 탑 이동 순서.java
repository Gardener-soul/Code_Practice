import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		sb.append((int)Math.pow(2, N)-1).append("\n");
		
		Hanoi(N,1,2,3);
		System.out.println(sb);
		
	}
	
	static void Hanoi(int N, int start, int mid, int end) {
		
		if(N==1) {
			sb.append(start + " " + end +"\n");
			return;
		}
		
		Hanoi(N-1, start, end, mid);
		sb.append(start + " " + end + "\n");
		Hanoi(N-1, mid, start, end);
		
	}
	
}