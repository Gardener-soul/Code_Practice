import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Queue<Integer> num = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		for(int i=1; i<=N; i++ ) {
			num.offer(i);
		}
		
		while(num.size()!=1) {
			num.poll();
			num.offer(num.poll());
		}
		
		System.out.println(num.peek());
		
	}
}