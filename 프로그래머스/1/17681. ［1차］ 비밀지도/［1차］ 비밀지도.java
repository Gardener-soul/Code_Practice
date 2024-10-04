/*
1. 한 변의 길이가 n인 정사각형 배열 공백 or 벽
2. 두 개 합쳐서 벽이면 1 둘다 공백이면 공백

1. 일단 이걸 합쳐서 숫자 하나를 이진수로 만드는걸 구현해야하는군.
*/
import java.util.*;

class Solution {
    public static String makeTwo(int a, int b, int len) {
        int[] arr = new int[len];
        int[] arr2 = new int[len];
        
        int tmp = len-1;
        while(true) {
            arr[tmp] = a%2;
            arr2[tmp] = b%2;
            tmp--;
            a/=2;
            b/=2;
            if(tmp<0) break;
        }
        
        // 조합
        String str = makeRes(arr, arr2);
        
        return str;
    }
    
    public static String makeRes(int[] arr, int[]arr2) {
        String res = "";
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==0 && arr2[i]==0) res+=" ";
            else res+="#";
        }
        return res;
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            answer[i] = makeTwo(arr1[i], arr2[i],n);
        }
        
        return answer;
    }
}