class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.length()-4;
        String stars = "";
        for(int i=0; i<len; i++){
            stars+="*";
        }
        String num = "";
        for(int i=len; i<phone_number.length(); i++){
            num+=phone_number.charAt(i);
        }
        answer = stars+num;
        return answer;
    }
}