import java.util.Arrays;

class Solution {
    public double[] solution(int[][] score) {
        double[] avg = new double [score.length];
		double[] cnt = new double [score.length];
		Arrays.fill(cnt, 1);
		
		for(int i=0; i<score.length; i++) {
				avg[i]+=(score[i][0]+score[i][1])/2.0;
		}
		
		for(int i=0; i<score.length; i++) {
			for(int j=i+1; j<score.length; j++) {
				if(avg[i]<avg[j]) {
					cnt[i]++;
				}else if (avg[i]>avg[j]) {
					cnt[j]++;
				}
			}
		}
        return cnt;
    }
}