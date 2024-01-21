import java.util.*;
import java.io.*;

/**
    1. Map을 통해 고유값인 아이디와, 정보를 담음 : 
    2. Set를 통해, 중복 아이디를 방지함 (몇명의 유저가 있는지 파악)
    3. 일단 split()을 통해 입력을 쪼개야 함.
*/

class Solution {
    public String[] solution(String[] record) {
        int len = record.length;
        
        String[][] str = new String[len][3];
        Map<String,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int ansLen = 0;
        
        for(int i=0; i<len; i++){
            String[] tmp = record[i].split(" ");
            set.add(tmp[1]);
            if(!tmp[0].equals("Leave")) {
                map.put(tmp[1],tmp[2]);
                str[i][0] = tmp[0];
                str[i][1] = tmp[1];
                str[i][2] = tmp[2];
            } else {
                str[i][0] = tmp[0];
                str[i][1] = tmp[1];
            }
            if(!tmp[0].equals("Change")) ansLen++;
        }
        
        String[] answer = new String[ansLen];
        int tmpa = 0;
        for(int i=0; i<str.length; i++){
            if(str[i][0].equals("Enter")){
                answer[tmpa++] = map.get(str[i][1]) + "님이 들어왔습니다.";
            }
            else if(str[i][0].equals("Leave"))
                answer[tmpa++] = map.get(str[i][1]) + "님이 나갔습니다.";
        }
        return answer;
    }
}