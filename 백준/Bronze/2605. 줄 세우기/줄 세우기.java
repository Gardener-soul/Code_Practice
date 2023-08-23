import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> line = new LinkedList<>();
		int N = scanner.nextInt(); // 줄 몇명 서는지
		
		for(int i=0; i<N; i++) {
			int p = scanner.nextInt();
			line.add(p, i+1);
		}
		for(int i=line.size()-1; i>=0; i--) {
			System.out.print(line.get(i)+" ");
		}
	}
}
