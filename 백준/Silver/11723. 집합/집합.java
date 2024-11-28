import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 모으기
        int loop = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int a = 0;

            if (!order.equals("all") && !order.equals("empty")) {
                a = Integer.parseInt(st.nextToken());
            }

            switch (order) {
                case "add":
                    set.add(a);
                    break;
                case "remove":
                    set.remove(a);
                    break;
                case "check":
                    sb.append(set.contains(a) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    if (set.contains(a)) {
                        set.remove(a);
                    } else {
                        set.add(a);
                    }
                    break;
                case "all":
                    for (int b = 1; b <= 20; b++) {
                        set.add(b);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.print(sb); // 한 번에 출력
    }
}
