import java.io.*;
import java.util.*;

public class BabyShark2 {
    static class Position {
        int r, c, distance;

        public Position(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }
    
    static int N, M, map[][], dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 }, dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 }, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        bw.append(Integer.toString(max));
        bw.flush();
        bw.close();
    }
    
    public static int bfs(int r, int c) {
        Queue<Position> queue = new LinkedList<Position>();
        boolean[][] visited = new boolean[N][M];
        
        visited[r][c] = true;
        queue.add(new Position(r, c, 0));

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            for (int d = 0; d < 8; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M || visited[nextR][nextC]) {
                    continue;
                }

                if (map[nextR][nextC] == 1) {
                    return now.distance + 1;
                }

                visited[nextR][nextC] = true;
                queue.add(new Position(nextR, nextC, now.distance + 1));
            }
        }
        
        return 0;
    }
}