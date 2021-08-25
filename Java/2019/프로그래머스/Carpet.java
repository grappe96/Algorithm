package Programmers;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

프로그래머스> 코딩테스트 연습> 완전탐색 > 카펫

문제 설명

Leo는 카펫을 사러 갔다가 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 
전체 카펫의 크기는 기억하지 못했습니다.
Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 
카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항

갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
*/
public class Carpet {
    public static int[] solution(int brown, int yellow) {
        int carpet = brown+yellow;
        int w = (int)Math.sqrt(carpet);
        int h = 0;
        while(w < brown/2){
            if(carpet%w != 0){
                w++;
                continue;
            }
            h = carpet/w;
            if (h > w) {
                int tmp = h;
                h = w;
                w = tmp;
            }
            if((w+h)*2-4 == brown)
                break;
            w++;
        }
        int[] answer = new int[2];
        answer[0] = w;
        answer[1] = h;
        return answer;
    }
    public static void main(String[] args) {
        for(int i:solution(18, 6))
            System.out.println(i);
    }
}