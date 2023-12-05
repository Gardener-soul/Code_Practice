class Solution {
    
    static int ans;
    static boolean[] chk;
    
    public static void powerset(int[] numbers, boolean[] chk, int target, int idx){
        
        if(idx==numbers.length){
            int tmp = 0;
            for(int i=0; i<chk.length; i++){
                if(chk[i]) {
                    tmp+=numbers[i];
                } else {
                    tmp-=numbers[i];
                }
            }
            
            if(tmp==target) ans++;
            
            return;
        }
        
        chk[idx] = false;
        powerset(numbers,chk,target,idx+1);
        
        chk[idx] = true;
        powerset(numbers,chk,target,idx+1);
        
    }
    
    public int solution(int[] numbers, int target) {  
        ans = 0;
        chk = new boolean[numbers.length];
        
        powerset(numbers,chk,target,0);
        
        return ans;
    }
}