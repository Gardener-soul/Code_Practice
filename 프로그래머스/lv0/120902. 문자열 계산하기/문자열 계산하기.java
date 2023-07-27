class Solution {
    public int solution(String my_string) {
        int answer =0;
        String[] sArr = my_string.split(" ");
        answer = Integer.parseInt(sArr[0]);
        
        for(int i=1; i<sArr.length; i++) {
        	if(sArr[i].equals("+")) {
        		answer+=Integer.parseInt(sArr[i+1]);
        	} else if(sArr[i].equals("-")) {
        		answer-=Integer.parseInt(sArr[i+1]);
        	}
        }
        return answer;
    }
}