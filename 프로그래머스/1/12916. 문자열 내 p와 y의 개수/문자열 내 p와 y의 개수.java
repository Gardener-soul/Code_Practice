class Solution {
    boolean solution(String s) {
        int yNum = 0;
        int pNum = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='y' || s.charAt(i)=='Y') yNum++;
            if(s.charAt(i)=='p' || s.charAt(i)=='P') pNum++;
        }

        if(yNum==0 && pNum==0) return true;
        else if(yNum==pNum) return true;
        else return false;
    }
}