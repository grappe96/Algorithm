package Programmers;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

프로그래머스> 코딩테스트 연습> 깊이/너비 우선 탐색(DFS/BFS)> 단어 변환

문제 설명

두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 
아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 2. words에 있는 단어로만 변환할 수 있습니다.

 예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.
두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

제한사항

각 단어는 알파벳 소문자로만 이루어져 있습니다.
각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
begin과 target은 같지 않습니다.
변환할 수 없는 경우에는 0를 return 합니다.
*/

import java.util.LinkedList;
import java.util.Queue;

public class ConvertWord {
    static class Node {
        String word;
        int depth;

        public Node(String w, int d){
            this.word = w;
            this.depth = d;
        }
    }
    public static int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<Node>();
        boolean[] visited = new boolean[words.length];
        int answer = 0;
        queue.add(new Node(begin, 0));

        while(!queue.isEmpty()){
            Node next = queue.poll();
            if(next.word.equals(target)){
                answer = next.depth;
                break;
            }
            for(int i=0;i<words.length;i++){
                if(!visited[i]){
                    int change = 0;
                    for(int j=0;j<next.word.length();j++){
                        if(next.word.charAt(j) != words[i].charAt(j))
                            change++;
                        if(change > 1)
                            break;
                    }
                    if(change == 1){
                        visited[i] = true;
                        queue.add(new Node(words[i], next.depth+1));
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin, target, words));
    }
}