import java.util.*;
class Solution {
    public int solution(String[] order) {
        int money = 0;
        String[] m4500 = {"iceamericano", "americanoice","hotamericano", "americanohot", "americano", "anything"};
        String[] m5000 = {"icecafelatte", "cafelatteice","hotcafelatte", "cafelattehot", "cafelatte"};
        
        for(int i = 0 ; i < order.length; i++){
            boolean tf = Arrays.asList(m4500).contains(order[i]);
            
            //4500원인 메뉴
            if(tf == true){
                money += 4500;
            } else {
                money += 5000;
            }
        }
        return money;
    }
}