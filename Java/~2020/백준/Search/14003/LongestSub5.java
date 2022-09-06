/*
문제

수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력

첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (-1,000,000,000 ≤ Ai ≤ 1,000,000,000)

출력

첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
둘째 줄에는 가장 긴 증가하는 부분 수열을 출력한다.
*/

import java.io.*;
import java.util.*;

public class LongestSub5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int[] num = new int[N+1];
        int[] idx = new int[N+1];
        ArrayList<Integer> LIS = new ArrayList<>();
        Stack<Integer> answer = new Stack<>();
        int max=1, len=0;
        st = new StringTokenizer(br.readLine());

        num[1] = Integer.parseInt(st.nextToken());
        LIS.add(num[1]);
        idx[1] = 1;
        for(int i=2;i<=N;i++){
            num[i] = Integer.parseInt(st.nextToken());
            if(LIS.get(LIS.size()-1) < num[i]){
                LIS.add(num[i]);
                idx[i] = LIS.size();
            } else {
                idx[i] = Collections.binarySearch(LIS, num[i]);
                if(idx[i] < 0){
                    idx[i] = Math.abs(idx[i]);
                    LIS.remove(idx[i]-1);
                    LIS.add(idx[i]-1, num[i]);
                }
            }
            max = Math.max(max, idx[i]);
        }
        bw.write(max + "\n");
        len = max;
        for(int i=N; i>0; i--){
            if(idx[i] == max){
                answer.push(num[i]);
                max--;
            }
            if(max == 0)
                break;
        }
        for(int i=0;i<len;i++)
            bw.write(answer.pop() + " ");
        bw.close();
    }
}