import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] dial = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int time = 0;

        for(int i=0; i<word.length(); i++){
            char a = word.charAt(i);
            time+=dial[a-17-'0'];
        }
        System.out.println(time);
    }
}
