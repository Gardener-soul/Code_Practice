class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0' <= 9) answer = true;
            else {
                answer = false;
                break;
            }
            if(i==s.length()-1) {
                if(s.length() == 4 || s.length() == 6) answer = true;
                else answer = false;
            }
        }
        return answer;
    }
}