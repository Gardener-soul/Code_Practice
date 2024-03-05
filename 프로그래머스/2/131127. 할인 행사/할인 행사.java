/*
1. 매일 한  가지 제품을 할인하는 행사 / 제품은 하루에 하나씩만 가능
2. 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우 회원가입
3. 최소 일자를 반환하면 된다.

1. 2차원 배열로 각 일자의 date를 저장해놓고, 순회 시킨후 일치하면 뿌린다 ㅇㅇ
*/
 
import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean flag = false;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<=discount.length-10; i++){
            
            int[] res = new int[number.length];
            
            for(int abc = 0; abc<number.length; abc++){
                res[abc] = number[abc];
            }
            
            for(int j=0; j<10; j++){
                for(int w=0; w<number.length; w++){
                    if(discount[i+j].equals(want[w])) res[w]--;
                }               
            }
            
            for(int n=0; n<number.length; n++){
                if(res[n]!=0) {
                    flag = false;
                    break;
                } else flag = true;
            }
            
            if(flag) {
                arr.add(i+1);
            }
        }
        
        answer = arr.size();
        
        return answer;
    }
}