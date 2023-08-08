import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int ans = A*B*C;
		List<Integer> result = new ArrayList<>();
		
		while(ans>=1) {
			result.add(ans%10);
			ans=ans/10;
		}
		int[] cnt = new int[10];
		for(int i=0; i<10; i++) {
			for(int j=0; j<result.size(); j++) {
			if(result.get(j)==i) {
				cnt[i]++;
			    }
			}
		}
		for(int i=0; i<10; i++) {
			System.out.println(cnt[i]);
		}
	}
}