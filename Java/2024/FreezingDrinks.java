import java.io.*;
import java.util.StringTokenizer;

public class FreezingDrinks {
    static class Cube {
        int r, c;

        public Cube(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, frame[][], dr[] = {-1, 1, 0, 0}, dc[] = {0, 0, -1, 1}, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        frame = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                frame[i][j] = tmp[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (frame[i][j] == 0) {
                    count++;
                    dfs(new Cube(i, j));
                }
            }
        }

        bw.append(Integer.toString(count));
        bw.flush();
        bw.close();
    }
    
    private static void dfs(Cube now) {
        frame[now.r][now.c] = 2; // 방문처리

        for (int d = 0; d < 4; d++) {
            int nextR = now.r + dr[d];
            int nextC = now.c + dc[d];

            if (nextR < 0 || nextC < 0 || nextR == N || nextC == M || frame[nextR][nextC] != 0) {
                continue;
            }

            dfs(new Cube(nextR, nextC));
        }
        
        return;
    }
}