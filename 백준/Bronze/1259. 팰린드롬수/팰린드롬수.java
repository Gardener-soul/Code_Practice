import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int N = scanner.nextInt();
			if(N==0) {
				break;
			}
			
			String str = String.valueOf(N);
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			String str1 = String.valueOf(sb);
			sb.reverse();
			String str2 = String.valueOf(sb);
			if(str1.equals(str2)) {
				System.out.println("yes");
			} else {System.out.println("no");}
			
		}
		scanner.close();
	}	
}