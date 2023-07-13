class Solution {
    public int solution(double n) {
        int answer = 0;
        for (int i=0; i<n+1; i++){
            if (n%i==0){
                answer+=1;
            }
        }
        return answer;
    }
}