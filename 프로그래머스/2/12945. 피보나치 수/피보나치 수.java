class Solution {
    
    public static int fibo(int a) {
        if(a==0) return 0;
        if(a==1) return 1;
        
        return fibo(a-1)+fibo(a-2);
    }
    
    public static int forFibo(int a){
        
        if(a<=1) return a;
        
        int[] fib = new int[a+1];
        fib[0] = 0;
        fib[1] = 1;
        
        for(int i=2; i<=a; i++){
            fib[i] = (fib[i-2] + fib[i-1]) % 1234567;
        }
        return fib[a];
    }
    
    public int solution(int n) {
        int fi = forFibo(n);
        return fi;
    }
}