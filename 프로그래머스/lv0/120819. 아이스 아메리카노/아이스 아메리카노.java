class Solution {
    public int[] solution(int money) {
        int a=2;
        int[] answer = new int [a];
        if (money>5500){
            answer[0]=money/5500;
            answer[1]=money-5500*answer[0];
        }else if (money==5500){
            answer[0]=1;
            answer[1]=0;
        } else{
            answer[0]=0;
            answer[1]=money;
        }
        return answer;
    }
}