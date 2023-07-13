class Solution {
    public String solution(String my_string) {
        String answer = "";
       //string은 안에 자유자재
        for (int i = my_string.length()-1; i>=0; i--) {
            answer += my_string.charAt(i);
        }
        return answer;
    }
}
/*
배열: arr.length
문자열: str /s str.length() / "sfsdf"
string[] str =  -> ["adsvsd", "ADasdsa", "Dfsfsd"]
str.length / str[1].length()
    
String / 메모리를 엄청 잡아먹음
StringBuilder / 
StringBuilder sb = new StringBuilder("");

sb.append(str);

string "asdsadas"
char : 하나의 문자
string: 하나의 문장
<2>
string -> char
my_string.charAt(i)
*/