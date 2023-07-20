class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String snum = String.valueOf(num);
        String k1 = String.valueOf(k);
        String[] sarr = snum.split("");
        for (int i=0; i<sarr.length; i++){
            if(sarr[i].equals(k1)){
                answer=i+1;
                break;
            } else answer=-1;
        }
        return answer;
    }
}