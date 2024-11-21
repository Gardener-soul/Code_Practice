class Solution {
    public static int Uclid(int a, int b) {
        
        while(b!=0) {
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        
        return a;  
    }
    
    public static int LCM(int a, int b) {
        return a*b/Uclid(a,b);
    }
    
    public int solution(int[] arr) {
        int res = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            res = LCM(res, arr[i]);
        }
        
        return res;
    }
}