package Programmers;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
코딩테스트 연습> 스택/큐 > 주식가격

문제 설명

초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

제한사항

prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
prices의 길이는 2 이상 100,000 이하입니다.
*/

import java.util.LinkedList;
import java.util.Queue;

public class StockValue {
    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Queue<Integer> queue = new LinkedList<>();
        for(int i : prices)
            queue.add(i);
        while(!queue.isEmpty()){
            int next = queue.peek();
            int idx = len-queue.size();
            for(int i=idx+1;i<len;i++){
                answer[idx]++;
                if(next > prices[i])
                    break;
            }
            queue.poll();
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] ans = solution(prices);
        for(int i : ans)
            System.out.print(i + " ");
        System.out.println();
    }
}