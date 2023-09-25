class Solution {
    
     public static void dfs(int[] numbers, int target, int idx, int sum){
        
        if(idx==numbers.length){
            if(target==sum){
                cnt++;
            }   
            
        } else {
            
        dfs(numbers, target, idx + 1, sum+numbers[idx]);
        dfs(numbers, target, idx + 1, sum-numbers[idx]);
        
        }
    }    
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0,0);
        int answer = cnt;
        return answer;
    } 
    
    static int cnt = 0;
}
