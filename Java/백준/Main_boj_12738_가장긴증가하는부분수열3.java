package boj;

import java.io.*;
import java.util.*;

public class Main_boj_12738_가장긴증가하는부분수열3 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> LIS = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int key, idx;

        key = Integer.parseInt(st.nextToken());
        LIS.add(key);
        for(int i=2;i<=N;i++){
            key = Integer.parseInt(st.nextToken());
            if(LIS.get(LIS.size()-1) < key)
                LIS.add(key);
            else {
                idx = Collections.binarySearch(LIS, key);
                if(idx < 0){
                    idx = -(idx+1);
                    LIS.set(idx, key);
                }
            }
        }
        bw.write(LIS.size() + "\n");
        bw.close();
    }
}