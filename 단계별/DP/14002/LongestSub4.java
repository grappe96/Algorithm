import java.io.*;
import java.util.*;

public class LongestSub2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int[] num = new int[N+1];
        int[] dp = new int[N+1];
        Stack<Integer> answer = new Stack<>();
        int max = 0, len;
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            len = 0;
            num[i] = Integer.parseInt(st.nextToken());
            for (int j=1; j<i; j++)
                if(num[j] < num[i] && len < dp[j])
                    len = dp[j];
            dp[i] = len+1;
            max = Math.max(max, dp[i]);
        }
        bw.write(max + "\n");
        for(int i=N; i>0; i--){
            if(dp[i] == max){
                answer.push(num[i]);
                max--;
            }
            if(max == 0)
                break;
        }
        len = answer.size();
        for(int i=0;i<len;i++)
            bw.write(answer.pop() + " ");
        bw.close();
    }
}