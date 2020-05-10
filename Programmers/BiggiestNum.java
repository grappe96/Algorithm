package Programmers;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

프로그래머스> 코딩테스트 연습> 정렬> 가장 큰 수

문제 설명

0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 예를 들어, 주어진 정수가 [6, 10, 2]라면 
 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 
순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항

numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
*/

import java.util.Arrays;
import java.util.Comparator;

public class BiggiestNum {
    public static String solution(int[] numbers) {
        String answer = "";
        String[][] num = new String[numbers.length][2];
        for(int i=0;i<numbers.length;i++){
            num[i][1] = Integer.toString(numbers[i]);
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            while(sb.length()<4){
                sb.append(num[i][1].charAt(idx));
                idx = (idx+1) % num[i][1].length();
            }
            num[i][0] = sb.toString();
        }
        Arrays.sort(num, Comparator.comparing(o1 -> o1[0]));
        if(num[numbers.length-1][1].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for(int i=numbers.length-1;i>=0;i--)
            sb.append(num[i][1]);
        answer = sb.toString();
        return answer;
    }

    public static void main(String args[]) {
        int[] numbers = { 3, 30, 34, 5, 9 };
        System.out.println(solution(numbers));
    }
}