class Solution {
    public int solution(String s) {
        int answer = 0;
        String tmp = "";
        if(s.charAt(0)!='-') {
            for(int i=0; i<s.length(); i++){
                tmp+=s.charAt(i);
            }
            answer=Integer.parseInt(tmp);
            answer*=1;
        } else {
            for(int i=1; i<s.length(); i++){
                tmp+=s.charAt(i);
            }
            answer=Integer.parseInt(tmp);
            answer*=-1;
        }
        return answer;
    }
}