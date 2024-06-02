import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N, M, max, cards[][];
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0;
        cards = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cards[i]);
            max = Math.max(max, cards[i][0]);
        }

        bw.append(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}
