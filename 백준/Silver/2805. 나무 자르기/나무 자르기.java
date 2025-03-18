import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tree = Integer.parseInt(st.nextToken());
        long cut = Integer.parseInt(st.nextToken());
        int[] trees = new int[tree];
        int lt=0 ,rt=0, mid=0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<tree; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            rt = Math.max(rt,trees[i]);
        }

        while(lt<=rt) {

            mid = (lt+rt)/2;
            long tmp = 0;

            for(int i=0; i<tree; i++) {
                if(trees[i]>mid) tmp += (trees[i] - mid);
            }

            if(tmp>=cut) lt=mid+1;
            else rt = mid-1;

        }

        System.out.println(rt);

    }
}
