package Programmers;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
코딩테스트 연습> 스택/큐 > 기능개발

문제 설명

여러 개의 쇠막대기를 레이저로 절단하려고 합니다. 
효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자릅니다. 

쇠막대기와 레이저의 배치는 다음 조건을 만족합니다.
- 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있습니다.
- 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓습니다.
- 각 쇠막대기를 자르는 레이저는 적어도 하나 존재합니다.
- 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않습니다.

이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있습니다.
 (a) 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 '()'으로 표현합니다. 
 또한 모든 '()'는 반드시 레이저를 표현합니다.
 (b) 쇠막대기의 왼쪽 끝은 여는 괄호 '('로, 오른쪽 끝은 닫힌 괄호 ')'로 표현됩니다.
쇠막대기와 레이저의 배치를 표현한 문자열 arrangement가 매개변수로 주어질 때, 잘린 쇠막대기 조각의 총 개수를 return 하도록 solution 함수를 작성해주세요.

제한사항

arrangement의 길이는 최대 100,000입니다.
arrangement의 여는 괄호와 닫는 괄호는 항상 쌍을 이룹니다.
*/

import java.util.Stack;

public class SteelStick {
    public static int solution(String arrangement) {
        Stack<Integer> stack = new Stack<>();
        boolean isOpen = true;
        int answer = 0;

        for(int i=0;i<arrangement.length();i++){
            if(arrangement.charAt(i) == '('){
                stack.push(0);
                isOpen = true;
            } else {
                if(isOpen){
                    stack.pop();
                    for(int j=0;j<stack.size();j++)
                        stack.set(j, stack.get(j)+1);
                } else {
                    int j = stack.size()-1;
                    stack.set(j, stack.get(j)+1);
                    answer += stack.pop();
                }
                isOpen = false;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";
        System.out.println(solution(arrangement));
    }
}