/*
1. 포켓몬 N마리 중에서 N/2 마리 만큼 가져갈 수 있음.
2. 포켓몬의 종류를 구하는거니까 Map을 사용
 1) map의 포켓몬들을 넣어놓고, N/2를 잡아놓기..
*/

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int catchPo = nums.length/2; // 잡을 수 있는 포켓몬 개수
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],1);
        }
        if(catchPo>map.size()) answer = map.size();
        else answer= catchPo;
        return answer;
    }
}