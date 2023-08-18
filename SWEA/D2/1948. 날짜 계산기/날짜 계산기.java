import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			int fm = scanner.nextInt(); //첫 번째 월
			int fd = scanner.nextInt(); //첫번째 날
			int sm = scanner.nextInt(); //2 번째 달
			int sd = scanner.nextInt(); //2번째 날
			int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			int sum = 0; //날짜 합
			
			if(fm==sm) {
				sum+=sd-fd+1;
			} else {
				//첫째날
				sum+=month[fm]-fd+1;
				//둘째날
				sum+=sd;
				for(int i=fm+1; i<sm; i++) { //1번 달과 2번달의 사잇값들만.
					sum+=month[i];
				}
			}
		System.out.println("#" + testCase + " " + sum);
		} //tc	
	}	
}