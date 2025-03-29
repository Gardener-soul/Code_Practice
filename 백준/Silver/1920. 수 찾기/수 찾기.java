import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int binarySearch(int[] arr, int a) {

        int lt = 0;
        int rt = arr.length-1;

        while(lt<=rt) {
            int mid = (lt+rt) / 2;

            if(arr[mid]==a) return 1;
            else if (arr[mid]<a) lt=mid+1;
            else rt=mid-1;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(arr);
        for(int i=0; i<M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr, tmp)).append('\n');
        }

        System.out.println(sb);
    }
}
