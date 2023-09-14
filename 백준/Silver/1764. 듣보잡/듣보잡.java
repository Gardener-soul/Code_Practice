import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		HashSet<String> D = new HashSet<>();
		for(int i=0; i<N; i++) {
			D.add(scanner.next());
		}
		
		List<String> str = new ArrayList<>();
		int cnt = 0;
		
		for(int i=0; i<M; i++) {
			String tmp = scanner.next();
			if(D.contains(tmp)) {
				cnt++;
				str.add(tmp);
			}
		}
		Collections.sort(str);
		System.out.println(cnt);
		for(int i=0; i<str.size(); i++) {
			System.out.println(str.get(i));
		}
	}
}