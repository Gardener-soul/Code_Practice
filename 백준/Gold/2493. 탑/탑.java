import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
	int cnt, num;

	public Pair(int cnt, int num) {
		super();
		this.cnt = cnt;
		this.num = num;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Stack<Pair> s = new Stack<>();

		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());

			while (!s.isEmpty()) {
				if (s.peek().num >= num) {
					System.out.print(s.peek().cnt + " ");
					break;
				}
				s.pop();
			}
			if (s.isEmpty()) {
				System.out.print("0 ");
			}
			s.add(new Pair(i, num));
		}
	}
}