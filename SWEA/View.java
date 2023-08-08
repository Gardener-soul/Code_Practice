import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num=0; //출력값 번호 매기기 위해 num 변수 설정.

		
		for(int t=1; t<=10; t++) {  //10개의 테스트케이스
			int n = sc.nextInt();
			int[] nArr = new int[n];
			for(int i=0; i<n; i++) {
			nArr[i] = sc.nextInt(); //빌딩 배열 생성완료
			}
			
			int sum=0;
			
		for(int i=2; i<nArr.length-2; i++) {
			int max = Math.max(nArr[i-2], Math.max(nArr[i-1], Math.max(nArr[i+1], nArr[i+2])));
			if(nArr[i]>max) {
				sum+=nArr[i]-max;
			}
		}
		num++;
		System.out.println("#" + num + " " + sum);		
		}
	}
}
