package boj;

import java.io.*;
import java.util.*;

public class Main_boj_14003_가장긴증가하는부분수열5 {

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
            if(LIS.get(LIS.size()-1) < num[i]) { // 가장 큰 수보다 클 때
                LIS.add(num[i]);
                idx[i] = LIS.size();
            } else {
                idx[i] = Collections.binarySearch(LIS, num[i]);
                if(idx[i] < 0){ // 없을 때
                    idx[i] = Math.abs(idx[i]);
                    LIS.set(idx[i]-1, num[i]);
                }else
                	idx[i] += 1;
            }
            max = Math.max(max, idx[i]);
        }
        bw.write(max+"\n");
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
            bw.write(answer.pop()+" ");
        bw.close();
    }
}