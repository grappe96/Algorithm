import java.io.*;
import java.util.*;

class house {
    int x;
    int y;
    house(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class NumberingComplex {
    public static int N;
    public static int[][] map;
    public static ArrayList<Integer> num;
    public static boolean[][] visited;
    public static Queue<house> queue;
    public static int idx;
    public static void main(String[] args) throws IOException {
        
        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            String[] s = br.readLine().split("");
            for(int j=1;j<=N;j++)
                map[i][j] = Integer.parseInt(s[j-1]);
        }
        num = new ArrayList<>();
        visited = new boolean[N+1][N+1];
        idx = 0;
        num.add(0);
        find(1,1);

        Collections.sort(num);
        for(int i : num)
            bw.write(i + "\n");
        bw.close();
    }
    public static void find(int a, int b){
        Queue<house> queue = new LinkedList<>();
        queue.add(new house(a, b));
        visited[a][b] = true;
        while(!queue.isEmpty()) {
            house neighbor = queue.poll();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for(int i=0;i<4;i++) {
                int x = neighbor.x+dx[i];
                int y = neighbor.y+dy[i];
                if(x>0 && y>0 && x<=N && y<=N && map[x][y]==1 && !visited[x][y]){
                    queue.add(new house(x, y));
                    visited[x][y] = true;
                    num.add(idx, num.get(idx)+1);
                }
            }
            if(queue.isEmpty() && neighbor.x+1<=N && neighbor.y+1<=N){
                idx++;
                num.add(0);
                find(neighbor.x+1, neighbor.y+1);
            }
        }
    }
}