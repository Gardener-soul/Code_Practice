import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] sarr = s.split(",");
        ArrayList<Integer> arr = new ArrayList<>();
        int max = 0;
        
        for(int i=0; i<sarr.length; i++) {
            String tmp = "";
            for(int j=0; j<sarr[i].length(); j++) {
                if(sarr[i].charAt(j)-'0' >=0 && sarr[i].charAt(j)-'0'<=9) tmp+=sarr[i].charAt(j);
            }
            arr.add(Integer.parseInt(tmp));
            max = Math.max(Integer.parseInt(tmp), max);
        }
        int[] chk = new int[max+1];
        int len = 0;
        for(int i=0; i<arr.size(); i++) {
            chk[arr.get(i)]++;
            len = Math.max(len, chk[arr.get(i)]);
        }
        int[] answer = new int[len];
        for(int i=0; i<chk.length; i++) {
            if(chk[i]!=0) answer[len-chk[i]] = i;
        }
        
        return answer;
    }
}