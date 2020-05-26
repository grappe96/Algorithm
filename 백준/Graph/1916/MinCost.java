/*
문제

N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 
우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. 
A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 
도시의 번호는 1부터 N까지이다.

입력

첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 
그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 
 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 
 그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 
 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.
그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 
출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.

출력

첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
*/

import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
    int city;
    int cost;
    Bus(int city, int cost){
        this.city = city;
        this.cost = cost;
    }
    @Override
    public int compareTo(Bus b){
        if(this.cost > b.cost)
            return 1;
        else if(this.cost == b.cost)
            return 0;
        else
            return -1;
    }
}
public class MinCost {
    public static ArrayList<Bus>[] path;
    public static int[] cost;
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        
        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        path = new ArrayList[N+1];
        cost = new int[N+1];
        for(int i=1;i<=N;i++){
            path[i] = new ArrayList<>();
            cost[i] = INF;
        }

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            path[u].add(new Bus(v,w));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Bus> pQueue = new PriorityQueue<>();
        pQueue.add(new Bus(s, 0));
        while(!pQueue.isEmpty()){
            Bus tmp = pQueue.poll();
            int city = tmp.city;
            int cst = tmp.cost;

            if(cst >= cost[city])
                continue;
            cost[city] = cst;

            for(Bus i : path[city]){
                int ct = i.city;
                int c = cst + i.cost;

                if(c >= cost[ct])
                    continue;
                pQueue.add(new Bus(ct, c));
            }
        }
        bw.write(cost[e] + "\n");
        bw.flush();
        bw.close();
    }
}