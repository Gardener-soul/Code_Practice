import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int hr=0, hc=0;
    static int la=0, ra=0; // 왼쪽 팔, 오른쪽 팔
    static int hl=0; // 허리 길이
    static int ll = 0, rl=0; // 왼쪽 다리, 오른쪽 다리

    public static void findHeart(boolean[][] arr, int n) {
        a: for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j]) {
                    hr=i+1;
                    hc=j;
                    break a;
                }
            }
        }
    }

    public static void findArm(boolean[][] arr, int n) {
        for(int i=0; i<hc; i++) {
            if(arr[hr][i]) la++;
        }
        for(int i=hc+1; i<n; i++) {
            if(arr[hr][i]) ra++;
        }
    }

    public static void findha(boolean[][] arr, int n) {
        int as = 0;
        for(int i=hr+1; i<n; i++) {
            if(arr[i][hc]) hl++;
            else {
                as=i;
                break;
            }
        }

        for(int i=as; i<n; i++) {
            if(arr[i][hc-1]) ll++;
            if(arr[i][hc+1]) rl++;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[n][n];
        for(int i=0; i<n; i++) {
            String tmp = br.readLine();
            for(int j=0; j<n; j++){
                char c = tmp.charAt(j);
                if(c=='*') arr[i][j] = true;
            }
        }

        findHeart(arr, n);
        System.out.println((hr+1) + " " + (hc+1));

        findArm(arr,n);
        findha(arr,n);
        System.out.println(la + " " +ra + " " + hl + " " + ll + " " + rl);

    }
}
