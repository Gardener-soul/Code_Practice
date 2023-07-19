class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        String[] arr = my_string.split("");
        String[] mir = my_string.split("");
        mir[num2] = arr[num1];
        mir[num1] = arr[num2];
    
        for (int i=0; i<mir.length; i++){
            answer+=mir[i];
    }
        return answer;
    }
}