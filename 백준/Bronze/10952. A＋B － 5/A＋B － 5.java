import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		List<Integer> arr = new ArrayList<>();
		int cnt = 0;
		
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a==0&&b==0) {
				break;
			}
			
			int sum = a+b;
			arr.add(sum);
			cnt++;
		}
		sc.close();
		for(int i=0; i<cnt; i++) {
			System.out.println(arr.get(i));
	}
}
}