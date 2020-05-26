/*
문제

재서기는 수혀니와 교외 농장에서 숨바꼭질을 하고 있다. 
농장에는 헛간이 많이 널려있고 재서기는 그 중에 하나에 숨어야 한다. 
헛간의 개수는 N(2 <= N <= 20,000)개이며, 1 부터 샌다고 하자.  
재서기는 수혀니가 1번 헛간부터 찾을 것을 알고 있다. 
모든 헛간은 M(1<= M <= 50,000)개의 양방향 길로 이어져 있고, 그 양 끝을 A_i 와 B_i(1<= A_i <= N; 1 <= B_i <= N; A_i != B_i)로 나타낸다. 
또한 어떤 헛간에서 다른 헛간으로는 언제나 도달 가능하다고 생각해도 좋다. 
재서기는 발냄새가 지독하기 때문에 최대한 냄새가 안나게 숨을 장소를 찾고자 한다. 
냄새는 1번 헛간에서의 거리(여기서 거리라 함은 지나야 하는 길의 최소 개수이다)가 멀어질수록 감소한다고 한다. 
재서기의 발냄새를 최대한 숨길 수 있는 헛간을 찾을 수 있게 도와주자!

입력

첫 번째 줄에는 N과 M이 공백을 사이에 두고 주어진다.
이후 M줄에 걸쳐서 A_i와 B_i가 공백을 사이에 두고 주어진다.

출력

출력은 한줄로 이루어지며, 세 개의 값을 공백으로 구분지어 출력해야한다. 
첫 번째는 숨어야 하는 헛간 번호를(만약 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호를 출력한다), 
두 번째는 그 헛간까지의 거리를, 세 번째는 그 헛간과 같은 거리를 갖는 헛간의 개수를 출력해야한다.
*/

import java.io.*;
import java.util.*;

public class HidenSeek {
    public static void main(String[] args) throws IOException {
        
        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] path = new ArrayList[N+1];
        int[] dist = new int[N+1];

        for(int i=1;i<=N;i++){
            path[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());
            path[A_i].add(B_i);
            if(A_i != 1)
                path[B_i].add(A_i);
        }
        LinkedList<Integer> Queue = new LinkedList<>();
        int dis = 0;
        dist[1] = 0;
        Queue.add(1);
        while(!Queue.isEmpty()){
            int tmp = Queue.poll();

            for(int i: path[tmp]){
                if(dist[i] == 0 || dist[i]>dist[tmp]+1){
                    dist[i] = dist[tmp]+1;
                    dis = Math.max(dis, dist[i]);
                    Queue.add(i);
                }
            }
        }
        int idx=0, cnt=0;
        for(int i=2;i<=N;i++){
            if(dist[i] == dis){
                if(idx == 0)
                    idx = i;
                cnt++;
            }
        }
        System.out.print(idx + " " + dis + " " + cnt);
    }
}