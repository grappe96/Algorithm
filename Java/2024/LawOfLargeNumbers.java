import java.io.*;
import java.util.*;

public class LawOfLargeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N, M, K, count, first, second, result;
        Integer numbers[];
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        numbers = new Integer[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers, Collections.reverseOrder());
        first = numbers[0];
        second = numbers[1];
        result = count = 0;

        for (int i = 0; i < M; i++) {
            if (++count == K) {
                result += second;
                count = 0;
                continue;
            }
            result += first;
        }

        bw.append(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
