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
		} //5개씩 끊어서 그 안에서 최댓값을 계산한다. But 파이썬적 접근은 지양한다.
      
		num++;
		System.out.println("#" + num + " " + sum);		
		}
	}
}

/* Insight : 먼저, 최댓값을 비교하는 메소드를 확실히 알아야한다
  변수의 활용을 잘해야한다. 17줄의 max값이 결국 자신의 값과 비교됨을 인식하자.
*/
