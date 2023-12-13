import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int aPos = 0;
        int bPos = 0;
        int[] answer = new int[id_list.length];
        boolean[] prob = new boolean[id_list.length];
        String[][] map = new String[report.length][2];
        boolean[][] chk = new boolean[id_list.length][id_list.length];
        int[][] cnt = new int[id_list.length][id_list.length];
        
        for(int i=0; i<report.length; i++){
            String[] tmp = new String[2];
            tmp = report[i].split(" ");
            map[i][0] = tmp[0];
            map[i][1] = tmp[1];
        }
        
        for(int i=0; i<report.length; i++){
            String a = map[i][0]; // 신고자
            String b = map[i][1]; // 쓰레기
            
            for(int j=0; j<id_list.length; j++){
                if(a.equals(id_list[j])) aPos = j;
                if(b.equals(id_list[j])) bPos = j;                   
           }
            
            if(!chk[aPos][bPos]) {
                chk[aPos][bPos] = true;
                cnt[aPos][bPos]++;
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            int tmp = 0;
            for(int j=0; j<id_list.length; j++){
                if(cnt[j][i]==1) tmp++;
                if(tmp>=k) {
                    prob[i]=true;
                    break;
                }
            }
        }
    
        for(int i=0; i<id_list.length; i++){
            for(int j=0; j<id_list.length; j++){
                if(cnt[i][j]==1 && prob[j]) answer[i]++;
            }
        }
        
        return answer;
    }
}