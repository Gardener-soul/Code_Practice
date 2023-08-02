class Solution {
    public int solution(String A, String B) {
        String a1 = A;
		int answer = 0;
		
		for(int i=0; i<A.length(); i++) {
			if(A.equals(B)) {
				return answer=i;
			}
			a1=A.substring(A.length()-1)+A.substring(0,A.length()-1);
			A=a1;
		}
		return answer=-1;
    }
}