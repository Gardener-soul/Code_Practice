import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        // 공백을 포함한 배열로 분리
        String[] sarr = s.split(" ", -1);
        
        for (int i = 0; i < sarr.length; i++) {
            if (!sarr[i].isEmpty()) {
                // 첫 문자가 알파벳인 경우 대문자로 변환
                if (Character.isLetter(sarr[i].charAt(0))) {
                    sb.append(Character.toUpperCase(sarr[i].charAt(0)));
                } else {
                    sb.append(sarr[i].charAt(0));
                }

                // 나머지 문자를 소문자로 변환
                for (int j = 1; j < sarr[i].length(); j++) {
                    sb.append(Character.toLowerCase(sarr[i].charAt(j)));
                }
            }
            // 단어 사이에 공백 추가
            if (i < sarr.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
