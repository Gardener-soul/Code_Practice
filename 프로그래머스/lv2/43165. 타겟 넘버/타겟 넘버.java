class Solution {
    
    static int sum;
    static int answer;
    
    public static void tf(int[] numbers, boolean[] chk, int target, int idx){
        sum=0;
        if(idx == numbers.length){
            
            for(int i=0; i<numbers.length; i++){
                if(chk[i]){
                    sum+=numbers[i];
                } else {
                    sum-=numbers[i];
                }
            }
            
            if(sum == target){
                answer++;
            }
            
            return;
        }
        
        chk[idx] = false;
        tf(numbers, chk, target, idx+1);
        
        chk[idx] = true;
        tf(numbers, chk, target, idx+1);
    }
    
    public int solution(int[] numbers, int target) {
        boolean[] chk = new boolean[numbers.length];
        tf(numbers, chk, target, 0);
        
        return answer;
    }
}