import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] origin = br.readLine().toCharArray();
        int[] oriArr = new int[26];
        for(int i=0; i<origin.length; i++) {
            oriArr[origin[i]-'A']++;
        }

        int ans = 0;
        for(int i=0; i<n-1; i++) {
            int len = 0;
            char[] tmp = br.readLine().toCharArray();

            if(tmp.length-origin.length>=-1 && tmp.length-origin.length<=1) {
                int[] ori = Arrays.copyOf(oriArr, oriArr.length);
                int[] tmpArr = new int[26];

                for(int j=0; j<tmp.length; j++) {
                    tmpArr[tmp[j]-'A']++;
                }

                for(int a=0; a<26; a++) {
                   len += Math.abs(ori[a] - tmpArr[a]);
                }

                if(tmp.length == origin.length) {
                    if(len==0 || len==2) ans++;
                } else if(len==1) ans++;

            }

        }
        System.out.println(ans);

    }
}
