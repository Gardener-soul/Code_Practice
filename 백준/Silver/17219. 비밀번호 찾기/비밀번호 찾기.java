import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		for(int i=0; i<N; i++) {
			String a = scanner.next();
			String b = scanner.next();
			map.put(a, b);
		}
		
		for(int i=0; i<M; i++) {
			String str = scanner.next();
			System.out.println(map.get(str));
		}
	}
}