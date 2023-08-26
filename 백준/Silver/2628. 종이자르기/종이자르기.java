import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int ga = scanner.nextInt();
		int se = scanner.nextInt();
		List<Integer> garo = new ArrayList<>();
		List<Integer> sero = new ArrayList<>();
		int N = scanner.nextInt();
		
		garo.add(0);
		garo.add(ga);
		sero.add(0);
		sero.add(se);
		
		for(int n=1; n<=N; n++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			if(a==0) {
				sero.add(b);
			} else if (a==1) {
				garo.add(b);
			}
		}
		
		Collections.sort(garo);
		Collections.sort(sero);
		
		int maxga = 0;
		int maxse = 0;
		
        for(int i=0; i<garo.size()-1; i++) {
			maxga = Math.max(maxga, (garo.get(i+1)-garo.get(i)));
		}
		
        for(int i=0; i<sero.size()-1; i++) {
			maxse = Math.max(maxse, (sero.get(i+1)-sero.get(i)));
		}
		
		int ans = maxga * maxse;
		
		System.out.println(ans);

	}
}