import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		// "(" 이면 무지성 푸시, if ")" 이면 괄호 pop
		// size가 1이상이면 NO
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			Stack<Character> g = new Stack<>();
			String str = scanner.next();
			String ans = "NO";
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='(') {
					g.push(str.charAt(i));
				}
				if(str.charAt(i)==')') {
					if(g.size()==0) {
						g.push(str.charAt(i));
					} else {
						if(g.peek()=='(') {
							g.pop();
						}
					}
				}
			}
			
			if(g.size()==0) {
				ans="YES";
				System.out.println(ans);
			} else {
				System.out.println(ans);
			}
			
		}
		
	}
	
}