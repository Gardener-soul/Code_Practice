class Solution {
    public String solution(int age) {
        String answer = "";
        String[] en = {"a","b","c","d","e","f","g","h","i","j"};
        if (age==1000){
            answer="baaa";
        } else if (age>=100&&age<1000){
                    int a=age/100;
                    age=age-100*a;
                    int b=age/10;
                    int c=age%10;
                    answer=en[a]+en[b]+en[c];
                } else if (age>=1&&age<=9){
            int a=age%10;
            answer = en[a];
        }
            else { 
                int a=age/10;
                int b=age%10;
                answer = en[a]+en[b];
        } 
        return answer;
    }
}