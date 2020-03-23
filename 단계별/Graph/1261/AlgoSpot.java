/*
문제

알고스팟 운영진이 모두 미로에 갇혔다. 
미로는 N*M 크기이며, 총 1*1크기의 방으로 이루어져 있다. 
미로는 빈 방 또는 벽으로 이루어져 있고, 빈 방은 자유롭게 다닐 수 있지만, 벽은 부수지 않으면 이동할 수 없다.
알고스팟 운영진은 여러명이지만, 항상 모두 같은 방에 있어야 한다. 
 즉, 여러 명이 다른 방에 있을 수는 없다. 
어떤 방에서 이동할 수 있는 방은 상하좌우로 인접한 빈 방이다. 
 즉, 현재 운영진이 (x, y)에 있을 때, 이동할 수 있는 방은 (x+1, y), (x, y+1), (x-1, y), (x, y-1) 이다. 
 단, 미로의 밖으로 이동 할 수는 없다.
벽은 평소에는 이동할 수 없지만, 알고스팟의 무기 AOJ를 이용해 벽을 부수어 버릴 수 있다. 
벽을 부수면, 빈 방과 동일한 방으로 변한다.
만약 이 문제가 알고스팟에 있다면, 운영진들은 궁극의 무기 sudo를 이용해 벽을 한 번에 다 없애버릴 수 있지만, 안타깝게도 이 문제는 Baekjoon Online Judge에 수록되어 있기 때문에, sudo를 사용할 수 없다.
현재 (1, 1)에 있는 알고스팟 운영진이 (N, M)으로 이동하려면 벽을 최소 몇 개 부수어야 하는지 구하는 프로그램을 작성하시오.

입력

첫째 줄에 미로의 크기를 나타내는 가로 크기 M, 세로 크기 N (1 ≤ N, M ≤ 100)이 주어진다. 
다음 N개의 줄에는 미로의 상태를 나타내는 숫자 0과 1이 주어진다. 
0은 빈 방을 의미하고, 1은 벽을 의미한다.
(1, 1)과 (N, M)은 항상 뚫려있다.

출력

첫째 줄에 알고스팟 운영진이 (N, M)으로 이동하기 위해 벽을 최소 몇 개 부수어야 하는지 출력한다.
*/

import java.io.*;
import java.util.*;

class Room implements Comparable<Room> {
    int x;
    int y;
    int wall;
    Room(int x, int y, int wall){
        this.x = x;
        this.y = y;
        this.wall = wall;
    }
    @Override
    public int compareTo(Room r){
        if(this.wall > r.wall)
            return 1;
        else if(this.wall == r.wall)
            return 0;
        else
            return -1;
    }
}
public class AlgoSpot {
    public static void main(String[] args) throws IOException {
        
        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map;
        int[][] num;
        int INF = Integer.MAX_VALUE;

        map = new int[N+1][M+1];
        num = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            String[] s = br.readLine().split("");
            for(int j=1;j<=M;j++){
                num[i][j] = INF;
                map[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        PriorityQueue<Room> pQueue = new PriorityQueue<>();
        num[1][1] = 0;
        pQueue.add(new Room(1, 1, num[1][1]));

        while(!pQueue.isEmpty()){
            Room next = pQueue.poll();

            if(next.x == M && next.y == N){
                bw.write(next.wall + "\n");
                break;
            }
            
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            for(int i=0; i<4; i++){
                int x = next.x + dx[i];
                int y = next.y + dy[i];
                
                if(x>0 && y>0 && x<=M && y<=N){
                    if(num[y][x] > num[next.y][next.x]+map[y][x]){
                        num[y][x] = num[next.y][next.x]+map[y][x];
                        pQueue.add(new Room(x, y, num[y][x]));
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}