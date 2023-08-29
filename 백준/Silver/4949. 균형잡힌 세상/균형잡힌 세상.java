import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			Stack<Character> g = new Stack<>();
			
			String str = scanner.nextLine();
			String ans = "no";
			
			if(str.equals(".")) {
				break;
			}
			
			for(int i=0; i<str.length(); i++) {
				
				if(str.charAt(i)=='(' || str.charAt(i)=='[') {
					g.push(str.charAt(i));
				}
				
				if(str.charAt(i)==')') {
					if(g.size()!=0) {
						if(g.peek()=='(') {
							g.pop();
						} else {g.push(str.charAt(i));}
				
					} else if (g.size()==0) {
						g.push(str.charAt(i));
					}
				}
				
				if(str.charAt(i)==']') {
					if(g.size()!=0) {
						if(g.peek()=='[') {
							g.pop();
						} else {g.push(str.charAt(i));}
				
					} else if (g.size()==0) {
						g.push(str.charAt(i));
					}
				}

			}
			
			if(g.size()==0) {
				ans = "yes";
				System.out.println(ans);
			} else {System.out.println(ans);}
			
		}
	}
}