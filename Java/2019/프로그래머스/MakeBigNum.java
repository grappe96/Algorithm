package Programmers;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
코딩테스트 연습> 탐욕법(Greedy)> 큰 수 만들기

문제 설명

어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 
이 중 가장 큰 숫자는 94 입니다.
문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건

number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
*/

public class MakeBigNum {
    public static StringBuilder sb = new StringBuilder();
    public static int findBig(String s, int k, int i){
        int max = s.charAt(i), idx = i;
        for(int j=i+1;j<=i+k;j++){
            if(max < s.charAt(j)){
                max = s.charAt(j);
                idx = j;
            }
        }
        sb.append(s.charAt(idx));
        return idx;
    }
    public static String solution(String number, int k) {
        for(int i=0; i<number.length(); i++){
            if(k != 0){
                int idx = findBig(number, k, i);
                if(sb.length() == number.length()-k)
                    break;
                k -= idx-i;
                i = idx;
            }else
                sb.append(number.charAt(i));
        }
        String answer = sb.toString(); 
        return answer;
    }
    public static void main(String[] args) {
        String number = "999";
        int k = 2;
        System.out.println(solution(number, k));
    }
}