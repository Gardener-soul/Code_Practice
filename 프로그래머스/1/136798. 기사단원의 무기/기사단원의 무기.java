class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++){
            int cnt = 0;

            for (int j = 1; j <= (int) Math.sqrt(i); j++){
                if (i % j == 0){
                    cnt += 2;
                }
                if (j * j == i){
                    cnt -= 1;
                } 
            }

            answer += limit < cnt ? power : cnt;
        }


        return answer;
    }
}