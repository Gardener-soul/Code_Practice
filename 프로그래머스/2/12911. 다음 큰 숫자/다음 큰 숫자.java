class Solution {
    
    public static int cnt1(int a){
        int cnt = 0;
        while(a>=1){
            if(a%2==1) cnt++;
            a/=2;
        }
        return cnt;
    }
    
    public static int find(int onecnt, int a){
        boolean flag = false;
        int res = 0;
        while(!flag){
            int bcnt = 0;
            for(int i=a+1; i<Integer.MAX_VALUE; i++){
                bcnt = cnt1(i);
                if(onecnt == bcnt){
                    res = i;
                    flag = true;
                    break;
                }
            }
        } 
        return res;
    }
    
    public int solution(int n) {
        int answer = 0;
        int n1 = cnt1(n);
        answer = find(n1,n);
        return answer;
    }
}