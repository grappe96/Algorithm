import java.io.*;
import java.util.*;

public class GameDevelopment {
    static class Character {
        int r, c, direction, count;

        public Character(int r, int c, int direction, int count) {
            this.r = r;
            this.c = c;
            this.direction = direction;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N, M, A, B, d, dr[] = { -1, 0, 1, 0 }, dc[] = { 0, 1, 0, -1 }, map[][], result = 0;
        boolean[][] visited;
        Queue<Character> queue = new LinkedList<Character>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
                
        visited[A][B] = true;
        queue.add(new Character(A, B, d, 0));
        result++;
        while (!queue.isEmpty()) {
            Character now = queue.poll();

            int nd = now.direction == 0 ? 3 : now.direction - 1;
            int nr = now.r + dr[nd];
            int nc = now.c + dc[nd];
            int count = now.count + 1;

            if (visited[nr][nc] || map[nr][nc] == 1) {
                if (count == 4) {
                    int backR = now.r - dr[d];
                    int backC = now.c - dc[d];
    
                    if (map[backR][backC] == 1) {
                        break;
                    }
                    nr = backR;
                    nc = backC;
                    nd = now.direction;
                    count = 0;
                } else {
                    nr = now.r;
                    nc = now.c;
                }
            } else {
                count = 0;
                result++;
            }

            visited[nr][nc] = true;
            queue.add(new Character(nr, nc, nd, count));
        }
        
        bw.append(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
