import java.io.*;
import java.util.StringTokenizer;

public class Main_BoJ_10830_행렬제곱 {
    static int N;
    static long A[][];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        A = new long[N][N];
        long B = Long.parseLong(st.nextToken()), answer[][] = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        answer = powerOfMatrix(B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                bw.write(answer[i][j]%1000 + " ");
            bw.write('\n');
        }
        bw.flush();
    }

    private static long[][] powerOfMatrix(long n) {
        if (n == 1)
            return A;

        long[][] res = powerOfMatrix(Math.floorDiv(n, 2));
        if (n % 2 == 0)
            return matrixMultiplication(res, res);
        else
            return matrixMultiplication(matrixMultiplication(A, res), res);
    }
    
    private static long[][] matrixMultiplication(long[][] a, long[][] b){
        long[][] result = new long[N][N];

        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++)
                    result[i][j] += ((a[i][k] % 1000) * (b[k][j] % 1000)) % 1000;
            }

        return result;
    }
}
