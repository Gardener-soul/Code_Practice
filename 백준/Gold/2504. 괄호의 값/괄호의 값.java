import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Stack<Character> st = new Stack<>();
		
		String str = scanner.next();
		int len = str.length();
		
		int res = 0;
		int sub = 1;
		for(int i=0; i<len; i++) {
			
			char a = str.charAt(i);
			
			if(a=='(') {
				st.add(a);
				sub*=2;
			} else if(a=='[') {
				st.add(a);
				sub*=3;
			} else if(a==')') {
				
				if(st.size()==0 || st.peek()!='(') {
					res = 0;
					break;
				}
				
				if(str.charAt(i-1)=='(') {
					res+=sub;
				}
				
				st.pop();
				sub/=2;			
				
			}
			else if(a==']') {
				
				if(st.size()==0 || st.peek()!='[') {
					res = 0;
					break;
				}
				
				if(str.charAt(i-1)=='[') {
					res+=sub;
				}
				
				st.pop();
				sub/=3;		
				
			}
		}
		
		if(st.size()>0) System.out.println(0);
		else System.out.println(res);
	}
}