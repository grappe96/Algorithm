package Programmers;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

프로그래머스> 코딩테스트 연습> 완전탐색 > 소수 찾기

문제 설명

한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항

numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
*/
import java.util.HashMap;

public class FindingPrime {
    static HashMap<Integer, Integer> prime = new HashMap<>();
    static void permutation(int n, int r, String numbers, StringBuilder sb, boolean[] visited){
        if(sb.length() == r){
            int k = Integer.parseInt(sb.toString());
            if(k > 1){
                for(int j=2;j<=Math.sqrt(k);j++)
                    if(k%j == 0)
                        return;
                prime.put(k, 1);
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(visited[i])
                continue;
            sb.append(numbers.charAt(i));
            visited[i] = true;
            permutation(n, r, numbers, sb, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=numbers.length();i++)
            permutation(numbers.length(), i, numbers, sb, visited);
        return prime.size();
    }

    public static void main(String[] args) {
        String numbers = "1276543";
        System.out.println(solution(numbers));
    }
}