//Wrong Explanation

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

        for(int i=1;i<=N;i++)
            path[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());
            path[A_i].add(B_i);
            path[B_i].add(A_i);
        }
        int[] dist = new int[N+1];
        int idx=0, dis=0, cnt=0;
        LinkedList<Integer> Queue = new LinkedList<>();
        Queue.add(1);
        while(!Queue.isEmpty()){
            int tmp = Queue.poll();
            for(int i : path[tmp]){
                if(dist[i] == 0){
                    Queue.add(i);
                    dist[i] = dist[tmp]+1;
                    dis = Math.max(dis, dist[i]);
                }
            }
        }
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