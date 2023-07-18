class Solution {
    public int solution(int n) {
        int answer = 0;
        double sqrt = Math.sqrt(n);
        if (sqrt%1==0){
            answer = 1;
        } else {answer = 2;}
        return answer;
    }
}