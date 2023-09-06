class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        int n = is_suffix.length();
        int m = my_string.length();
        int num = 0;
        if(n>m) return answer;
        for(int i=m-n; i<m; i++){
            if(my_string.charAt(i)==is_suffix.charAt(num++)){
                answer = 1;
            } else{
                answer = 0;
            }
        }
        return answer;
    }
}