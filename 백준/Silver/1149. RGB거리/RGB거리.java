import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int red = 0;
    static int green = 1;
    static int blue = 2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());



        int[][] map = new int[cnt][3];

        for(int i=0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<cnt; i++){
            map[i][red] = Math.min(map[i][red]+map[i-1][green], map[i][red]+map[i-1][blue]);
            map[i][blue] = Math.min(map[i][blue] + map[i-1][red], map[i][blue]+map[i-1][green]);
            map[i][green] = Math.min(map[i][green] + map[i-1][red], map[i][green]+map[i-1][blue]);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            min = Math.min(min, map[cnt-1][i]);
        }
        System.out.println(min);
    }
}
