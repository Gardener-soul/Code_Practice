import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 지문에 나오는 단어 개수
        int M = Integer.parseInt(st.nextToken()); // 외울 단어의 길이 기준
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();

            if(tmp.length()>=M) map.put(tmp,map.getOrDefault(tmp,0)+1);
        }

        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((e1,e2) -> {
            int rep = e2.getValue().compareTo(e1.getValue());
            if(rep!=0) return rep;

            int len = Integer.compare(e2.getKey().length(), e1.getKey().length());
            if(len!=0) return len;

            return e1.getKey().compareTo(e2.getKey());

        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> ans : entryList) {
            sb.append(ans.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
