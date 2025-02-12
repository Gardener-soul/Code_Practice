import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Team {
    public int team, score;

    public Team(int team, int score) {
        this.team = team;
        this.score = score;
    }

    public String toString() {
        return "team : " + team +" " + "score " + score;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int repeat = Integer.parseInt(br.readLine());
        for(int r=0; r<repeat; r++) {
            int playerNum = Integer.parseInt(br.readLine());
            int[] player = new int[playerNum];

            st = new StringTokenizer(br.readLine());
            int maxTeamNum = 0;
            for(int i=0; i<playerNum; i++) {
                player[i] = Integer.parseInt(st.nextToken());
                maxTeamNum = Math.max(maxTeamNum, player[i]);
            }

            int[] teamCnt = new int[maxTeamNum+1];
            for(int i=0; i<playerNum; i++) {
                teamCnt[player[i]]+=1;
            }

            int[][] board = new int[maxTeamNum+1][6];
            int score = 1;

            for(int i=0; i<playerNum; i++) {
                if(teamCnt[player[i]]<6) continue;
                for(int j=0; j<6; j++) {
                    if(board[player[i]][j]!=0) continue;
                    if(board[player[i]][j]==0) {
                        board[player[i]][j] = score++;
                        break;
                    }
                }
            }

            int minScore = Integer.MAX_VALUE;
            ArrayList<Team> arr = new ArrayList<>();

            for(int i=0; i<=maxTeamNum; i++) {
                int tmp = 0;
                if(board[i][0]==0) continue;
                for(int j=0; j<4; j++) {
                    tmp+=board[i][j];
                }
                arr.add(new Team(i, tmp));
                minScore = Math.min(tmp, minScore);
            }

            int chk = 0;
            ArrayList<Integer> chkArr = new ArrayList<>();
            for(int i=0; i<arr.size(); i++) {
                if(arr.get(i).score==minScore) {
                    chk++;
                    chkArr.add(arr.get(i).team);
                }
            }

            int ans = 0;
            if(chk>=2) {
                Team[] score5 = new Team[chkArr.size()];

                for(int i=0; i<chkArr.size(); i++) {
                    score5[i] = new Team(chkArr.get(i), board[chkArr.get(i)][4]);
                }

                int finalMin = Integer.MAX_VALUE;
                for(int i=0; i<score5.length; i++) {
                    finalMin = Math.min(finalMin, score5[i].score);
                }

                for(int i=0; i<score5.length; i++) {
                    if(finalMin == score5[i].score) ans = score5[i].team;
                }

            } else if (chk==1) {
                ans = chkArr.get(0);
            }

            System.out.println(ans);

        }
    }
}
