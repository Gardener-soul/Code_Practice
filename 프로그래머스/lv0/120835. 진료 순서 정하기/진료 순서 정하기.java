import java.util.Arrays;

class Solution {
    public int[] solution(int[] emergency) {
	int[] copy = new int [emergency.length];
	Arrays.fill(copy,1);

	for(int i=0; i<emergency.length-1; i++) {
		for(int j=i+1; j<=emergency.length-1; j++) {
		if(emergency[i]<emergency[j]) {
			copy[i]+=1;
		} else {copy[j]+=1;}
	}
}
        return copy;
    }
}