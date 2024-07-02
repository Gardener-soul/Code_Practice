import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        String[] arr = input.split(" ");
        int len = arr.length;
        if(arr[0].isEmpty()) len--;
        if(arr[arr.length-1].isEmpty()) len--;
        if(len==-1) len=0;
        System.out.println(len);
    }
}
