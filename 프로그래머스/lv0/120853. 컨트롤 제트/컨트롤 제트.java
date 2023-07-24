class Solution {
    public int solution(String s) {
		s=s.replaceAll("\"","");
		String[] sarr = s.split(" ");
		int sum = 0;
		
		for(int i=0; i<sarr.length; i++) {
			if(sarr[i].equals("Z")) {
				sum=sum-Integer.valueOf(sarr[i-1]);
			} else sum+=Integer.valueOf(sarr[i]);
		}
        return sum;
    }
}