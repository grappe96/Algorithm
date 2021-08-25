/*
문제

방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 
단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력

첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1≤V≤20,000, 1≤E≤300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 
둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다. 
셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. 
u와 v는 서로 다르며 w는 10 이하의 자연수이다. 
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력

첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 
시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.
*/

import java.io.*;
import java.util.*;

class Vertex implements Comparable<Vertex> {
    int idx;
    int wgt;
    Vertex(int idx, int wgt){
        this.idx = idx;
        this.wgt = wgt;
    }
    @Override
    public int compareTo(Vertex v){
        if(this.wgt > v.wgt)
            return 1;
        else if(this.wgt == v.wgt)
            return 0;
        else
            return -1;
    }
}
public class ShortestPath {
    public static ArrayList<Vertex>[] adj;
    public static int[] dist;
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        
        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        adj = new ArrayList[V+1];
        dist = new int[V+1];

        for(int i=1;i<=V;i++){
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Vertex(v,w));
        }
        PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
        pQueue.add(new Vertex(K, 0));

        while(!pQueue.isEmpty()){
            Vertex tmp = pQueue.poll();
            int idx = tmp.idx;
            int wgt = tmp.wgt;

            if(wgt >= dist[idx])
                continue;
            dist[idx] = wgt;

            for(Vertex i : adj[idx]){
                int Idx = i.idx;
                int W = wgt + i.wgt;

                if(W >= dist[Idx])
                    continue;
                pQueue.add(new Vertex(Idx, W));
            }
        }
        for(int i=1;i<=V;i++){
            if(dist[i]<INF)
                bw.write(dist[i] + "\n");
            else
                bw.write("INF\n");
        }
        bw.flush();
        bw.close();
    }
}