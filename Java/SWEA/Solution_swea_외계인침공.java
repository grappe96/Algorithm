package week10;

import java.io.*;
import java.util.*;

public class Solution_swea_외계인침공 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int tc=1;tc<=T;tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long first = Long.parseLong(st.nextToken()), second = 0, third = 0;
            if(N>1)
            	second = Long.parseLong(st.nextToken());
    		third = Math.max(first, second); 
    		second = third;
        	for(int i=2;i<N;i++) {
        		third = Math.max(first+Long.parseLong(st.nextToken()), second);
        		first = second;
        		second = third;
        	}
            System.out.println("#"+tc+" "+third);
        }
        return;
    }
}