package Programmers;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

프로그래머스> 코딩테스트 연습> 해시> 전화번호 목록

문제 설명

전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

제한 사항

phone_book의 길이는 1 이상 1,000,000 이하입니다.
각 전화번호의 길이는 1 이상 20 이하입니다.
*/

import java.util.Arrays;

public class ListOfPhonebook {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for (String s : phone_book) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length()-1; i++) {
                sb.append(s.charAt(i));
                if (Arrays.asList(phone_book).contains(sb.toString())) {
                    System.out.println(sb.toString());
                    answer = false;
                    break;
                }
            }
            if (!answer)
                break;
        }
        return answer;
    }

    public static void main(String args[]) {
        String[] phone_book = { "119", "9764223", "1195524421" };
        System.out.println(solution(phone_book));
    }
}
