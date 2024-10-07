import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] num1 = new int[11];
        int[] num2 = new int[11];
        int[] res = new int[11];
        
        for(int i=0; i<X.length(); i++) {
            int tmp = X.charAt(i)-'0';
            num1[tmp]++;
        }
        for(int i=0; i<Y.length(); i++) {
            int tmp = Y.charAt(i)-'0';
            num2[tmp]++;
        }
        for(int i=0; i<11; i++) {
            int min = Math.min(num1[i], num2[i]);
            res[i] = min;
        }
        for(int i=10; i>=0; i--) {
            for(int j=0; j<res[i]; j++) {
                answer.append(i);                
            }
        }
                
        if (answer.toString().equals("")) {
            return "-1";
        } else if (answer.toString().startsWith("0")) {
            return "0";
        } else {
            return answer.toString();
        }
        
    }
}