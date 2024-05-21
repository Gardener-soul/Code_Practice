import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] arr = new int[50];

        //A: 17 , a : 49. Z: 42. z:74
        for(int i=0; i<word.length(); i++){
            int tmp = word.charAt(i) - '0';
            if(tmp>48) tmp-=32;

            arr[tmp]++;
        }

        int max = 0;
        for(int i=0; i<50; i++){
            max = Math.max(max,arr[i]);
        }

        int same = 0;
        int ans = 0;
        for(int i=0; i<50; i++){
            if(max==arr[i]) {
                same++;
                ans = i;
            }
        }

        char answer = (char) ((char) ans+ '0');
        if(same>1) System.out.println('?');
        else System.out.println(answer);
    }
}
