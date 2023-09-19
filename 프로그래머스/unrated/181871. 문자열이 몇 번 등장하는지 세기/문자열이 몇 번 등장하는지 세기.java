class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int n = pat.length();
        for(int i=0; i<=myString.length()-n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<i+n; j++){
                sb.append(myString.charAt(j));
            }
            if(pat.equals(sb.toString())){
                answer++;
            }  
        }
        return answer;
    }
}