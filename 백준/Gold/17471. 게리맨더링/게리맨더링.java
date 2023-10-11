import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    static int N, ans, peoT, peoF;
    static boolean[] chk;
    static boolean[] dfsChk;
    static int[] peo;
    static ArrayList<Integer>[] graph;
    
    public static void powerSet(int idx) {
        
        if(idx==N) { // chk의 T F가 결정된 상황
            
            peoT = 0;
            peoF = 0;
            
            int trueI = 0;
            for(int i=1; i<=N; i++) {
                if(chk[i]) {
                    trueI = i;
                    break;
                }
            }
            
            int falseI = 0;
            for(int i=1; i<=N; i++) {
                if(!chk[i]) {
                    falseI = i;
                    break;
                }
            }
            
            dfsChk = new boolean[N+1];
            dfs(trueI, true);
            dfs(falseI, false);
            
            int linkChk = 0;
            for(int i=1; i<=N; i++) {
                if(!dfsChk[i]) {
                    linkChk++;
                }
            }
            
            if(linkChk==0) {
                for(int i=1; i<=N; i++) {
                    if(chk[i]) {
                        peoT+=peo[i];
                    } else {
                        peoF+=peo[i];
                    }
                }
                ans = Math.min(ans, Math.abs(peoT-peoF));
            }
            return;
        }
        
        chk[idx] = true;
        powerSet(idx+1);
        chk[idx] = false;
        powerSet(idx+1);
        
    }
    
    public static void dfs(int idx, boolean flag) {    
        
        if(idx == 0) return; // 
        
        dfsChk[idx] = true;
        
        for(int nextI : graph[idx]) {
            if(dfsChk[nextI] || chk[nextI]!=flag) continue;
            dfs(nextI, flag);
        }
        
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        chk = new boolean[N+1];
        peo = new int[N+1]; //사람 수
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            peo[i] = Integer.parseInt(st.nextToken());
        }
        
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            for(int j=0; j<tmp; j++) {
                int a = Integer.parseInt(st.nextToken());
                
                graph[i].add(a);
            }
        }
        
        powerSet(1);
        
        if(ans==Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}