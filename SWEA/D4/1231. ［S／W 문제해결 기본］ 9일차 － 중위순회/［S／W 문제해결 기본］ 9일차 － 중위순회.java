import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static char[] arr;
	static int L;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for(int testCase = 1; testCase<=10; testCase++) {
			
			int N = scanner.nextInt(); //몇줄 받을거임
			L = N+1;
			arr = new char[L]; //배열의 시작을 1로 맞추고 싶음.
			scanner.nextLine(); //개행을 하나 제거해줌.
			
			for(int i=1; i<arr.length; i++) {
				String str = scanner.nextLine(); //한줄씩 nextLine을 통해 받아와야한다.
				String[] s = str.split(" "); //split으로 그 한 줄을 스페이스바 단위로 쪼개서 s배열에 넣어준다.
				
				arr[i] = s[1].charAt(0); //String에서 char로 변환할 때 charAt을 사용하거나 toCharArray를 사용해야한다. 분류방법에 따라서 달라지지만.
			} //arr배열 잘 받아짐
		
			System.out.print("#" + testCase + " ");
			inOrder(1);
			System.out.println();
		} //tc

	} //main
	
	public static void inOrder(int n) {
		
		if(n<L) {
			
			inOrder(n*2);
			if(arr[n]!=' ') System.out.print(arr[n]);
			inOrder(n*2+1);
			
		}
		
	}

}