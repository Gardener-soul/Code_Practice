import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for(int testCase = 1; testCase <= 10; testCase++) {
			Queue<Integer> nums = new LinkedList<>(); //Queue가 매 TC 마다 초기화 되어야할거 같음.
			int[] ans = new int[8]; //나중에 답 배열
			scanner.nextInt(); //의미없는 테스트 케이스 번호 입력
			for(int n=0; n<8; n++) { //암호 개수 0부터 8까지 입력
				nums.add(scanner.nextInt());
			} //queue 숫자 잘 입력됨
			
			// 1사이클은 5번의 숫자 감소로 이루어짐. 이게 계속 이루어져야함.
			outer: while(true) {
				for(int i=1; i<=5; i++) {
					int a = nums.remove(); //첫번째 값 제거
					// 제거 하고 연산 과정에서 0보다 작거나 같은 조건을 달아야함.
					if(a-i>0) {
						nums.add(a-i); //그리고 이 a값을 i만큼 빼고 다시 넣기
					} else {
						nums.add(0);
						break outer;
					}
				} //이게 하나의 사이클
			}
			System.out.print("#" + testCase + " ");
			while(!nums.isEmpty()) {
				System.out.print(nums.poll()+" ");
			}
			System.out.println();
		} //tc 반복문
	} //main
}
