import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        double[] nArr = new double[numlist.length];
		int[] answer = new int [nArr.length];
		
		for(int i=0; i<numlist.length; i++) {
			if(numlist[i]-n<0) {
				nArr[i]=Math.abs(numlist[i]-n)+0.5;
			} else {nArr[i]=numlist[i]-n;}
		}
		
		Arrays.sort(nArr);
		
		for(int i=0; i<nArr.length; i++) {
			if(nArr[i]%1!=0) {
				answer[i]=(int)Math.abs(nArr[i]-(n+0.5));
			} else {answer[i] =(int)nArr[i]+n;}
		}
        return answer;
    }
}