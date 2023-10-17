import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
		Arrays.sort(A); // 2 4 5 9
		Arrays.sort(B); // 1 2 3 6
		
		int cnt = 0;
		for(int i=0; i<B.length; i++) {
			if(A[cnt]<B[i]) {
				cnt++;
			}
		}
        return cnt;
    }
}