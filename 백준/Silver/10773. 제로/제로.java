import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		Stack<Integer> num = new Stack<>();
			
        for(int i=0; i<T; i++) {
				int a = scanner.nextInt();
				if(a==0) {
					num.pop();
				} else {num.push(a);}
			}
	
		int sum = 0;
		while(!num.isEmpty()) {
			sum+=num.pop();
		}
			
		System.out.println(sum);
	}
}