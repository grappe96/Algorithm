import java.io.*;
import java.util.StringTokenizer;

public class UntilBecomingOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N, K, count, target;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 0;
        target = N;

        while (target != 1) {
            if (target % K == 0) {
                target /= K;
            } else {
                target -= 1;
            }
            count++;
        }
        
        bw.append(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
