import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        for(int testCase = 1; testCase<=10; testCase++) {
            Stack<Character> gwal = new Stack<>(); // 괄호 스택 생성
            int N = scanner.nextInt(); //괄호의 숫자
            String gwalho = scanner.next();
            int ans = 0;
            //N이 짝수일 때만 시작
            if(N%2==0) {
                 
                //잠깐만, 괄호를 입력받아야하잖아?
//              System.out.println(gwalho);
                for(int i=0; i<N; i++) { //조건문의 크기 설정은 어떻게 할건지?
                     
//                  gwal.push(gwalho.charAt(i)); //괄호를 이제, 하나씩 입력받을 수 있게 되었음.
                    if(gwalho.charAt(i)=='[' || gwalho.charAt(i) == '{' || gwalho.charAt(i)== '(' || gwalho.charAt(i)=='<') {
                        gwal.push(gwalho.charAt(i)); //만약 열린 괄호일 때, 괄호를 넣는다.
                    } 
                     
                    if(gwalho.charAt(i)==']'&&(gwal.peek()=='{'||gwal.peek()=='('||gwal.peek()=='<')) {
                        ans=0;
                        break;
                    } else if(gwalho.charAt(i)=='}'&&(gwal.peek()=='['||gwal.peek()=='('||gwal.peek()=='<')) {
                        ans=0;
                        break;
                    } else if(gwalho.charAt(i)==')'&&(gwal.peek()=='{'||gwal.peek()=='['||gwal.peek()=='<')) {
                        ans=0;
                        break;
                    } else if(gwalho.charAt(i)=='>'&&(gwal.peek()=='{'||gwal.peek()=='('||gwal.peek()=='[')) {
                        ans=0;
                        break;
                    }
                     
                    if(gwalho.charAt(i)==']'&&gwal.peek()=='[') {
                        gwal.pop(); 
                    }else if(gwalho.charAt(i)=='}'&&gwal.peek()=='{') {
                        gwal.pop();
                    }else if(gwalho.charAt(i)==')'&&gwal.peek()=='(') {
                        gwal.pop();
                    }else if(gwalho.charAt(i)=='>'&&gwal.peek()=='<') {
                        gwal.pop();
                    }
                } 
                if(gwal.size()==0) {
                    ans = 1;
                } else {ans=0;} 
            } else { //N이 홀수일 때
                ans=0;
            }
            System.out.println("#" + testCase +" " + ans);
        } //tc 문    
    }   
}
