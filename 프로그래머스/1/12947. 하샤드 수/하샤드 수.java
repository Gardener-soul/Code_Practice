class Solution {
    
    static int sum;
    
    public static void numSum(int a){
        while(a>=1){
            sum+=a%10;            
            a/=10;
        }
    }
    
    public boolean solution(int x) {
        sum = 0;
        numSum(x);
        if(x%sum==0) return true;
        else return false;
    }
}