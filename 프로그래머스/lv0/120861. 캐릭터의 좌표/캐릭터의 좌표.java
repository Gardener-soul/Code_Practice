import java.util.*;

class Solution {   

    public int[] solution(String[] keyinput, int[] board) {
        int[] now = {0, 0};                             //현재 위치좌표
        int maxWidth=board[0]/2;                        //x축 최대 좌표
        int maxLength=board[1]/2;                       //y축 최대 좌표
        for (int i = 0; i < keyinput.length; i++) {
            if(keyinput[i].equals("left")) {            //left를 눌렀을때
                now[0]-= (now[0]>-(maxWidth)?1:0);      //x축 (-)최대좌표보다 크면 1, 아니면 0을 뺌    
            } else if(keyinput[i].equals("right")) {    //이하 동일
                now[0]+= (now[0]<(maxWidth)?1:0);
            } else if(keyinput[i].equals("down")) {
                now[1]-= (now[1]>-(maxLength)?1:0);
            } else if(keyinput[i].equals("up")) {
                now[1]+= (now[1]<(maxLength)?1:0);
            }
         }
        
    return now;
}
}

        
//         int[] answer = new int[2];
// 	    Arrays.fill(answer, 0);
        
//         for(int i=0; i<keyInput.length; i++) {
// 		if(keyInput[i].equals("left")) {
// 			answer[0]=answer[0]-1;
// 		} else if(keyInput[i].equals("right")) {
// 			answer[0]=answer[0]+1;
// 		} else if(keyInput[i].equals("up")) {
// 			answer[1]=answer[1]+1;
// 		} else if(keyInput[i].equals("down")) {
// 			answer[1]=answer[1]-1;
// 		}
// 	}
        
//         for(int i=0; i<board.length; i++) {
// 		if(answer[i]>board[i]/2) {
// 			answer[i]=board[i]/2;
// 		}else if(answer[i]<-board[i]/2) {
// 			answer[i]=-board[i]/2;
// 		}
// 	}
//        return answer; 