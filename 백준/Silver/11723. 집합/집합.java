import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void add(HashSet<Integer> set, int a) {
        set.add(a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<loop; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int a = 0;
            if(!order.equals("all") && !order.equals("empty")) a = Integer.parseInt(st.nextToken());

            if(order.equals("add")) set.add(a);
            else if (order.equals("remove")) set.remove(a);
            else if (order.equals("check")) {
                if(set.contains(a)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if (order.equals("toggle")) {
                if (set.contains(a)) set.remove(a);
                else set.add(a);
            }
            else if (order.equals("all")){
                for(int b=1; b<=20; b++) set.add(b);
            }
            else if (order.equals("empty")) set.clear();
        }
        System.out.println(sb);
    }
}
