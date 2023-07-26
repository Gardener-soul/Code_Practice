import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        for(int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) != 'x') {
                myString = myString.substring(i);
                break;
            }
        }
        String[] answer = myString.split("x+");
        // System.out.println(Arrays.toString(answer));
        Arrays.sort(answer);
        return answer;
    }
}