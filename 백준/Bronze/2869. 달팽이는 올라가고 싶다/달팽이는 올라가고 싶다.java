import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double A = scanner.nextInt();
		double B = scanner.nextInt();
		double V = scanner.nextInt();
		
		System.out.println((int)Math.ceil((V-A)/(A-B))+1);
		
	}
}