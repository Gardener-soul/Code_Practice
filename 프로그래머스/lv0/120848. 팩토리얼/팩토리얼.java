class Solution {
    public int solution(int n) {
        int answer = 0;
        int num =1;
        int i=1;
        while (n>=num){
            answer+=1;
            i+=1;
            num=num*i;
        }
        return answer;
    }
}