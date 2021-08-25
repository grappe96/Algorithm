package Programmers;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
코딩테스트 연습> 힙> 이중우선순위큐

문제 설명

이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
 명령어	 수신 탑(높이)
 I 숫자	 큐에 주어진 숫자를 삽입합니다.
 D 1	큐에서 최댓값을 삭제합니다.
 D -1	큐에서 최솟값을 삭제합니다.
이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 
모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

제한사항

operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
operations의 원소는 큐가 수행할 연산을 나타냅니다.
원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
*/

import java.util.Iterator;
import java.util.LinkedList;

public class TwoOpPQueue {
    public static int[] solution(String[] operations) {
        LinkedList<Integer> pQueue = new LinkedList<>();
        for(String s : operations){
            String[] arr = s.split(" ");
            if(arr[0].equals("I")){
                int n = Integer.parseInt(arr[1]);
                if(pQueue.isEmpty())
                    pQueue.add(n);
                else{
                    Iterator<Integer> it = pQueue.iterator();
                    int idx = 0;
                    while (it.hasNext()) {
                        if (it.next() > n) {
                            pQueue.add(idx, n);
                            break;
                        }
                        if (++idx == pQueue.size()){
                            pQueue.addLast(n);
                            break;
                        }
                    }
                }
            } else {
                if(!pQueue.isEmpty()){
                    if (arr[1].equals("-1"))
                        pQueue.pollFirst();
                    else
                        pQueue.pollLast();
                }
            }
        }
        int[] answer = new int[2];
        if(pQueue.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = pQueue.pollLast();
            answer[1] = pQueue.pollFirst();
        }
        return answer;
    }
   public static void main(String[] args) {
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};
        int[] ans = solution(operations);
        for(int i : ans)
            System.out.print(i + " ");
        System.out.println();
   }
}