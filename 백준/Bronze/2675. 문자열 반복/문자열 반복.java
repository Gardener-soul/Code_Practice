import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int repeat = Integer.parseInt(st.nextToken());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < repeat; i++) {
            st = new StringTokenizer(br.readLine());
            int re = Integer.parseInt(st.nextToken()); // 반복 개수
            String word = st.nextToken();
            for (int k = 0; k < word.length(); k++) {
                for (int j = 0; j < re; j++) {
                    answer.append(word.charAt(k));
                }
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}
