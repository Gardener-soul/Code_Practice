class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int a = n/10;
        if (n>=10){
            answer=12000*n+2000*k-2000*a;
        } else {answer=12000*n+2000*k;}
        return answer;
    }
}