import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String N = scanner.next();
		int num = Integer.parseInt(N);
		int len = N.length();
		int idx = 0;
		
		for(idx=num-len*9; idx<num; idx++) {
		
			int tmp = len;			
			int tmpNum = idx;
			int sum = tmpNum;
			
			while(tmp>0) {
				
				sum+=tmpNum%10;
				tmpNum/=10;
						
				tmp--;
			}
			
			if(sum==num) {
				break;
			}
			
		}
		
		if(idx!=num) {			
			System.out.println(idx);
		}else {
			System.out.println(0);
		}
		
	} //main문
}