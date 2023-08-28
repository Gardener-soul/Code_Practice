import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		//1234567
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> num = new LinkedList<>();
		int N = scanner.nextInt();
		for(int i=1; i<=N; i++) {
			num.offer(i);
		}
		int D = scanner.nextInt();
		
		System.out.print("<");
		while(num.size()!=1) {
			for(int i=1; i<D; i++) {
				num.offer(num.poll());
			}
			
			System.out.print(num.poll()+ ", ");
		}
		System.out.print(num.poll()+">");
	}	
}