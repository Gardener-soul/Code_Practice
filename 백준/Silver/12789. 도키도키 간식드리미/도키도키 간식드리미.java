import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Stack<Integer> num = new Stack<>();
		int N = scanner.nextInt();
		int idx=1;
		String ans = "Nice";
		
		while(N!=0) {
			int a = scanner.nextInt();
			
			if(num.size()!=0) {
				if(num.peek()<=a) {
					break;
				} else {
					num.add(a);
				}
			} else {num.add(a);}
			
			while(true) {
				if(num.size()!=0) {
					if(num.peek()==idx) {
						num.pop();
						idx++;
					} else {break;}
				} else {break;}
			}
			N--;
		}
		
		if(num.size()!=0){
			ans = "Sad";
		}
		
		if(N==1) {
			ans="Nice";
		}
		
		System.out.println(ans);
		
	}
}