/*
문제

널리 잘 알려진 자료구조 중 최대 힙이라는 것이 있다. 
최대 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
배열에 자연수 x를 넣는다.
배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

입력

첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 
다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 
입력되는 자연수는 2^31보다 작다.

출력

입력에서 0이 주어진 회수만큼 답을 출력한다. 
만약 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력하면 된다.
*/

import java.io.*;
import java.util.*;

public class MaxHeap {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("Test/test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> heap = new ArrayList<>();
        heap.add(Integer.MAX_VALUE);

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(heap.size() < 2)
                    bw.write(num + "\n");
                else{
                    bw.write(heap.get(1) + "\n");
                    heap.set(1, heap.get(heap.size()-1));
                    heap.remove(heap.size()-1);

                    int idx = 1;
                    while((idx*2) < heap.size()){
                        int m = idx*2;
                        int r = m+1;
                        int max = heap.get(m);
                        if(r < heap.size() && max < heap.get(r)){
                            max = heap.get(r);
                            m = r;
                        }
                        if(heap.get(idx) > max)
                            break;
                        int tmp = heap.get(idx);
                        heap.set(idx, heap.get(m));
                        heap.set(m, tmp);
                        idx = m;
                    }
                }
            }else{
                heap.add(num);
                int idx = heap.size()-1;
                int l = idx/2;
                while(idx > 1 && heap.get(l) < heap.get(idx)){
                    int tmp = heap.get(l);
                    heap.set(l, heap.get(idx));
                    heap.set(idx, tmp);
                    idx = l;
                    l = idx/2;
                }
            }
        }
        bw.close();
    }
}