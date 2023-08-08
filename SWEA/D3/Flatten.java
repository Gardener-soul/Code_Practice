import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt=1;
		for(int n=0; n<10; n++) {
			int dump = sc.nextInt();
			int[] dumpArr = new int[100];
			for(int d=0; d<100; d++) {
				dumpArr[d]=sc.nextInt();
			} // dumpArr 배열 생성
			
			for(int i=0; i<99; i++) {
				int minidx = i;
				for(int j=i+1; j<100; j++) {
					if(dumpArr[minidx] > dumpArr[j]) {
						int tmp = dumpArr[i];
						dumpArr[i] = dumpArr[j];
						dumpArr[j] = tmp;
					} 
				}
			} //크기 순으로 정렬 완료
			
			while(dump>0) {
				dumpArr[99]--;
				dumpArr[0]++;
				dump--;
				Arrays.sort(dumpArr);
			} //dump값이 0이 될 때까지, 가장 큰 값에서, 가장 작은 값으로 더하고. dump를 하나씩 뺀다. 이후 계속 정렬
			System.out.println("#" + cnt + " " + (dumpArr[99]-dumpArr[0]));
			cnt++;
		}
	}
}

//Insight : 컴퓨터가 많은 정렬을 수행한다고 해서 겁먹지 말자. 그냥 정렬하라고 하고 풀어보자.
