/*
문제

N×M크기의 배열로 표현되는 미로가 있다.
    1	0	1	1	1	1
    1	0	1	0	1	0
    1	0	1	0	1	1
    1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 
칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력

첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 
다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 
각각의 수들은 붙어서 입력으로 주어진다.

출력

첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 
항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
*/
import java.io.*;
import java.util.*;

class location {
    int x;
    int y;

    location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class NavigatingMaze {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] map = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            s = br.readLine().split("");
            for(int j=1;j<=M;j++)
                map[i][j] = Integer.parseInt(s[j-1]);
        }
        boolean[][] visited = new boolean[N+1][M+1];
        Queue<location> Queue = new LinkedList<>();
        int[][] count = new int[N+1][M+1];
        Queue.add(new location(1, 1));
        count[1][1] = 1;
        visited[1][1] = true;
        while(!Queue.isEmpty()){
            location next = Queue.poll();
            if(next.x==N && next.y==M)
                break;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for(int i=0;i<4;i++){
                int x = next.x+dx[i];
                int y = next.y+dy[i];
                if(x>0 && y>0 && x<=N && y<=M && map[x][y]==1 && !visited[x][y]){
                    Queue.add(new location(x, y));
                    visited[x][y] = true;
                    if(count[x][y] == 0)
                        count[x][y] = count[next.x][next.y]+1;
                    else
                        count[x][y] = Math.min(count[next.x][next.x]+1, count[x][y]);
                }
            }
        }
        bw.write(count[N][M] + "\n");
        bw.close();
    }
}