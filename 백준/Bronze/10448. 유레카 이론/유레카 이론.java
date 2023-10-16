import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static List<Integer> num;
	
	public static int fac(int N) {
		
		if(N<=1) {
			return 1;
		}
			
		return N + fac(N-1);
		
	}
	
	public static boolean chk() {
		
		for(int i=0; i<num.size(); i++) {
			int sum = 0;
			sum+=num.get(i);
			for(int j=0; j<num.size(); j++) {
				int sum2 = sum;
				sum2=sum+num.get(j);
				for(int k=0; k<num.size(); k++) {
					int sum3 = sum2;
					sum3=sum2+num.get(k);
					if(sum3==N) return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		num = new ArrayList<>();
		
		int idx = 1;
		while(true) {
			int a = fac(idx);
			num.add(a);
			
			if(a>1000) {
				break;
			}
			idx++;
		}
		
		for(int testCase = 1; testCase<=T; testCase++) {
			N = scanner.nextInt();
			
			if(chk()) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
	
}