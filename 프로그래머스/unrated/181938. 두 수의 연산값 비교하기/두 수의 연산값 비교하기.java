class Solution {
    public int solution(int a, int b) {
        int answer = 2*a*b;
        String stra = String.valueOf(a)+String.valueOf(b);
        if(Integer.parseInt(stra)>=answer){
            answer = Integer.parseInt(stra);
        }
        return answer;
    }
}