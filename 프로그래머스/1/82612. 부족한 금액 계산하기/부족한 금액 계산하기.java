class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        int n = 1;
        while(true){
            answer+=price*n++;
            if(n-1==count) break;        
        }
        if(money-answer>0) return 0;
        else return Math.abs(money-answer);
    }
}