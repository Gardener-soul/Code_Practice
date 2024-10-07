class Solution {
    public int solution(String s) {
        int answer = 0, tmp=1, el=0;
        char x = s.charAt(0);
        
        for(int i=1; i<s.length(); i++) {   
            
            if(x==s.charAt(i)) tmp++;
            else el++;            
                            
            if(tmp==el && i+1<s.length()) {
                tmp=0;
                el=0;
                x = s.charAt(i+1);
                answer++;
            }
            
        }        
        answer++;
        return answer;
    }
}