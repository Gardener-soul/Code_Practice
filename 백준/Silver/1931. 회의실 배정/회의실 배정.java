import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int time = Integer.parseInt(st.nextToken());
        int[][] arr = new int[time][2];

        for(int i=0; i<time; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) {
                    return o1[0]-o2[0];
                }

                return o1[1]-o2[1];
            }
        });

        int ans = 0;
        int end = 0;
        for(int i=0; i<time; i++){
            if(end<=arr[i][0]){
                end = arr[i][1];
                ans++;
            }
        }

        System.out.println(ans);
    }
}
