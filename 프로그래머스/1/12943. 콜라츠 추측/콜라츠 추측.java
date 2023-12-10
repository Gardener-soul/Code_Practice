class Solution {
    
    static long now,res,ans;
    
    public static long collatz(long n, long level){
        
        ans = level;
        
        if(n==1) return ans;
        
        if(n%2==0) {
            now = n/2;
            collatz(now,ans+1);
        } else {
            now = n*3 + 1;
            collatz(now, ans+1);
        }
        if(ans>=500) return -1;
        else return ans;
    }
    
    public long solution(long num) {
        now = 0;
        ans = 0;
        res = 0;
        res = collatz(num,0);
        return res;
    }
}