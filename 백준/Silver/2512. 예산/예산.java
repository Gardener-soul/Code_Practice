import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int city = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[city];
        int lt = 0, rt =0;
        
        for(int i=0; i<city; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            rt = Math.max(rt,arr[i]);
        }
        int budget = Integer.parseInt(br.readLine());
        int mid = 0;

        while(lt<=rt) {
            mid = (lt+rt)/2;
            int tmp = 0;

            for(int i=0; i<city; i++) {
                if(mid<arr[i]) tmp+=mid;
                else tmp+=arr[i];
            }

            if(tmp<=budget) lt = mid+1;
            else rt = mid-1;
        }

        System.out.println(rt);

    }
}
