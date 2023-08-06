import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		List<Integer> num = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			num.add(sc.nextInt());
		}
		
		int sum = 0;
		for(int i=0; i<num.size(); i++) {
			sum += Math.pow(num.get(i), 2);
		}
		int ans = sum%10;
		System.out.println(ans);
	}
}