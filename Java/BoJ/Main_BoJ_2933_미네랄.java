import java.io.*;
import java.util.*;

public class Main_BoJ_2933_미네랄 {
    static class Block {
        int r, c;

        public Block(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C, map[][], bottom, dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
    static boolean visited[][];
    static List<Block> cluster;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < C; j++)
                map[i][j] = arr[j] == '.' ? 0 : 1;
        }

        N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int r = R - Integer.parseInt(st.nextToken());
            boolean check = false;

            if (i % 2 == 0) {
                for (int j = 0; j < C; j++)
                    if (map[r][j] == 1) {
                        map[r][j] = 0;
                        break;
                    }
            } else {
                for (int j = C - 1; j >= 0; j--)
                    if (map[r][j] == 1) {
                        map[r][j] = 0;
                        break;
                    }
            }

            visited = new boolean[R][C];
            for (int j = 0; j < R && !check; j++) {
                for (int k = 0; k < C; k++) {
                    if (map[j][k] == 0)
                        continue;
                    if (!visited[j][k]) {
                        visited[j][k] = true;
                        cluster = new ArrayList<Block>();
                        bottom = 0;
                        dfs(j, k);
                        if (bottom != R - 1) {
                            dropCluster();
                            check = true;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                if(map[i][j] == 0)
                    bw.append('.');
                else
                    bw.append('x');
            bw.append('\n');
        }

        bw.flush();
        bw.close();
    }

    private static void dropCluster() {
        boolean end = false;
        int size = cluster.size();

        for(int i=0;i<size;i++){
            Block now = cluster.get(i);
            map[now.r][now.c] = 0;
        }

        while (true) {
            for (int i = 0; i < size; i++) {
                Block now = cluster.get(i);
                if (now.r + 1 == R || map[now.r + 1][now.c] == 1) {
                    end = true;
                    break;
                }
            }

            if (end) {
                for (int i = 0; i < size; i++) {
                    Block now = cluster.get(i);
                    map[now.r][now.c] = 1;
                }
                break;
            }

            for (int i = 0; i < size; i++)
                cluster.get(i).r += 1;
        }
    }

    private static void dfs(int r, int c) {
        cluster.add(new Block(r, c));

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr<0||nc<0||nr>=R||nc>=C||visited[nr][nc]||map[nr][nc]==0)
                continue;
            
            visited[nr][nc] = true;
            bottom = Math.max(bottom, nr);
            dfs(nr, nc);
        }
    }
}
