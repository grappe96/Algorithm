package Java.BoJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BoJ_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int stuff[][] = new int[N + 1][2], dp[] = new int[K + 1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= stuff[i][0]; j--) {
                if (dp[j] < stuff[i][1] + dp[j-stuff[i][0]])
                    dp[j] = stuff[i][1] + dp[j - stuff[i][0]];
            }
        }
        
        System.out.println(dp[K]);
    }
}