class Solution {
    public int solution(int a, int b) {
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);
        String ansa = sa+sb;
        String ansb = sb+sa;
        
        if(Integer.parseInt(ansa)>=Integer.parseInt(ansb)){
            return Integer.parseInt(ansa);
        } else return Integer.parseInt(ansb);
    }
}