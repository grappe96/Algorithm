package Programmers;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

프로그래머스> 코딩테스트 연습> 완전탐색 > 숫자 야구

문제 설명

숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다.
각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 
그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.
* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃

예를 들어, 아래의 경우가 있으면
 A : 123
 B : 1스트라이크 1볼.
 A : 356
 B : 1스트라이크 0볼.
 A : 327
 B : 2스트라이크 0볼.
 A : 489
 B : 0스트라이크 1볼.
이때 가능한 답은 324와 328 두 가지입니다.
질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 
가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

제한사항

질문의 수는 1 이상 100 이하의 자연수입니다.
baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
*/
import java.util.HashSet;
import java.util.Iterator;

public class NumberBaseball {
    public static HashSet<String> ans = new HashSet<>();
    public static void Permutation(int n, int r, StringBuilder sb, boolean[] visited) {
        if (sb.length() == r) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i])
                continue;
            sb.append(i+1);
            visited[i] = true;
            Permutation(n, r, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
    public static HashSet<String> check(String answer, int s, int b){
        HashSet<String> tmp = new HashSet<>();
        Iterator<String> it = ans.iterator();
        while(it.hasNext()){
            String num = it.next();
            int strike=0, ball=0;
            for(int i=0;i<3;i++){
                if(num.charAt(i) == answer.charAt(i))
                    strike++;
                if(num.charAt(i)==answer.charAt((i+1)%3) || num.charAt(i)==answer.charAt((i+2)%3))
                    ball++;
            }
            if(s==strike && b==ball)
                tmp.add(num);
        }
        return tmp;
    }
    public static int solution(int[][] baseball) {
        boolean[] visited = new boolean[9];
        StringBuilder sb = new StringBuilder();
        Permutation(9, 3, sb, visited);
        for(int[] q : baseball)
            ans = check(Integer.toString(q[0]), q[1], q[2]);
        return ans.size();
    }
    public static void main(String[] args){
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        System.out.println(solution(baseball));
    }
}