/*
문제

N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 버스가 M개 있다. 
각 버스는 A, B, C로 나타낼 수 있는데, A는 시작도시, B는 도착도시, C는 버스를 타고 이동하는데 걸리는 시간이다. 
시간 C가 양수가 아닌 경우가 있다. 
C = 0인 경우는 순간 이동을 하는 경우, C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.
1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.

입력

첫째 줄에 도시의 개수 N (1 ≤ N ≤ 500), 버스 노선의 개수 M (1 ≤ M ≤ 6,000)이 주어진다. 
둘째 줄부터 M개의 줄에는 버스 노선의 정보 A, B, C (1 ≤ A, B ≤ N, -10,000 ≤ C ≤ 10,000)가 주어진다. 

출력

만약 1번 도시에서 출발해 어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면 첫째 줄에 -1을 출력한다. 
그렇지 않다면 N-1개 줄에 걸쳐 각 줄에 1번 도시에서 출발해 2번 도시, 3번 도시, ..., N번 도시로 가는 가장 빠른 시간을 순서대로 출력한다. 
만약 해당 도시로 가는 경로가 없다면 대신 -1을 출력한다.
*/

import java.io.*;
import java.util.*;

public class TimeMachine {
    static class Edge{
        public int source, destination, weight;
        public Edge(){
            source = destination = weight = 0;
        }
    }
    public static int noway = 0;
    
    static class BellmanFordGraph{
        int V, E;
        Edge[] edge;

        BellmanFordGraph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[e];
            for(int i=0;i<e;i++)
                edge[i] = new Edge();
        }

        public long[] BellmanFord(BellmanFordGraph graph, int src){
            int V = graph.V;
            int E = graph.E;
            long[] dist = new long[V];

            for(int i=0;i<V;i++)
                dist[i] = Long.MAX_VALUE;
            dist[src] = 0;

            for(int i=1;i<V;i++){
                for(int j=0;j<E;j++){
                    int u = graph.edge[j].source;
                    int v = graph.edge[j].destination;
                    int weight = graph.edge[j].weight;
                    if(dist[u] != Long.MAX_VALUE && dist[u]+weight < dist[v])
                        dist[v] = dist[u] + weight;
                }
            }

            for(int i=0;i<E;i++){
                int u = graph.edge[i].source;
                int v = graph.edge[i].destination;
                int weight = graph.edge[i].weight;
                if(dist[u] != Long.MAX_VALUE && dist[u]+weight < dist[v]){
                    noway = -1;
                    break;
                }
            }
            return dist;
        }
    }

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BellmanFordGraph graph = new BellmanFordGraph(N, M);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            graph.edge[i].source = Integer.parseInt(st.nextToken())-1;
            graph.edge[i].destination = Integer.parseInt(st.nextToken())-1;
            graph.edge[i].weight = Integer.parseInt(st.nextToken());
        }
        long[] dist = graph.BellmanFord(graph, 0);
        if(noway == -1)
            bw.write(noway + "\n");
        else{
            for(int i=1;i<N;i++){
                if(dist[i] == Long.MAX_VALUE)
                    bw.write("-1\n");
                else
                    bw.write(dist[i] + "\n");
            }
        }
        bw.close();
    }
}