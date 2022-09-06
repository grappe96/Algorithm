package study;

import java.io.*;
import java.util.*;

public class Main_boj_2824_≈‰∏∂≈‰ {

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        HashMap<Integer, Integer> factorA = new HashMap<>();
	        HashMap<Integer, Integer> factorB = new HashMap<>();
	        final int max = 1000000000;

	        int N = Integer.parseInt(br.readLine());
	        String[] a = br.readLine().split(" ");
	        for(int i=0; i<N; i++){
	            int num = Integer.parseInt(a[i]);
	            for(int j=2; j<=(int)Math.sqrt(num); j++){
	                int count = 0;
	                while(num%j==0){
	                    num /= j;
	                    count++;
	                }
	                if(factorA.containsKey(j))
	                    factorA.put(j, factorA.get(j) + count);
	                else
	                    factorA.put(j, count);
	            }
	            if(num != 1){
	                if(factorA.containsKey(num))
	                    factorA.put(num, factorA.get(num)+1);
	                else
	                    factorA.put(num, 1);
	            }
	        }
	        int M = Integer.parseInt(br.readLine());
	        String[] b = br.readLine().split(" ");
	        for(int i=0; i<M; i++){
	            int num = Integer.parseInt(b[i]);
	            for(int j=2; j<=(int)Math.sqrt(num); j++){
	                int count = 0;
	                while(num%j==0){
	                    num /= j;
	                    count++;
	                }
	                if(factorB.containsKey(j))
	                    factorB.put(j, factorB.get(j) + count);
	                else
	                    factorB.put(j, count);
	            }
	            if(num != 1){
	                if(factorB.containsKey(num))
	                    factorB.put(num, factorB.get(num)+1);
	                else
	                    factorB.put(num, 1);
	            }
	        }
	        long gcd = 1;
	        int check = 0;
	        for(int n : factorA.keySet()){
	            if(!factorB.containsKey(n))
	                continue;
	            for(int i=0; i<Math.min(factorA.get(n), factorB.get(n)); i++){
	                gcd *= n;
	                if(gcd >= max){
	                    gcd %= max;
	                    if(check==0)
	                        check = 1;
	                }
	            }
	        }
	        if(check == 1)
	            System.out.printf("%09d\n", gcd);
	        else
	            System.out.println(gcd);
	    }
	}