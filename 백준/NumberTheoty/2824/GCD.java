/*
문제

상근이는 학생들에게 두 양의 정수 A와 B의 최대공약수를 계산하는 문제를 내주었다. 
그런데, 상근이는 학생들을 골탕먹이기 위해 매우 큰 A와 B를 주었다.
상근이는 N개의 수와 M개의 수를 주었고, N개의 수를 모두 곱하면 A, M개의 수를 모두 곱하면 B가 된다.
이 수가 주어졌을 때, 최대공약수를 구하는 프로그램을 작성하시오.

입력

첫째 줄에 N이 주어진다.(1 ≤ N ≤ 1000) 
둘째 줄에는 N개의 정수가 공백으로 구분되어 주어진다. 
이 수는 모두 1,000,000,000보다 작고, N개의 수를 곱하면 A가 된다.
셋째 줄에 M이 주어진다.(1 ≤ M ≤ 1000) 
넷째 줄에는 M개의 정수가 공백으로 구분되어 주어진다. 
이 수는 모두 1,000,000,000보다 작고, M개의 수를 곱하면 B가 된다.

출력

두 수의 최대공약수를 출력한다. 
만약, 9자리보다 길다면, 마지막 9자리만 출력한다. 
(최대 공약수가 1000012028인 경우에는 000012028을 출력해야 한다)
*/
import java.io.*;
import java.util.*;

public class GCD {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> factorA = new HashMap<>();
        HashMap<Integer, Integer> factorB = new HashMap<>();

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
                if(gcd > 1000000000){
                    gcd %= 1000000000;
                    if(check == 0)
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