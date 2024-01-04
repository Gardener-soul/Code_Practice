class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] tf = new boolean[11];
        for(int i=0; i<numbers.length; i++){
            tf[numbers[i]] = true;
        }
        
        for(int i=1; i<10; i++){
            if(!tf[i]) answer+=i;
        }
        
        return answer;
    }
}