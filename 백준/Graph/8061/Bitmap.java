/*
문제

There is given a rectangular bitmap of size n x m. 
Each pixel of the bitmap is either white or black, but at least one is white. 
The pixel in i-th line and j-th column is called the pixel (i,j). 
The distance between two pixels p1=(i1,j1) and p2=(i2,j2) is defined as:
d(p1,p2)=|i1-i2|+|j1-j2|.

Write a program which:
 reads the description of the bitmap from standard input,
 for each pixel, computes the distance to the nearest white pixel,
 writes the results to the standard output.

입력

First line of the standard input there is a pair of integer numbers n, m separated by a single space, 1 ≤ n ≤ 182, 1 ≤ m ≤ 182. 
In each of the following n lines of the input exactly one zero-one word of length m, the description of one line of the bitmap, is written. 
On the j-th position in the line (i+1), 1 ≤ i ≤ n, 1 ≤ j ≤ m, is 1 if, and only if the pixel (i,j) is white.

출력

In the i-th line of the standard output, 1 ≤ i ≤ n, 
there should be written m integers f(i,1),…,f(i,m) separated by single spaces, 
where f(i,j) is the distance from the pixel (i,j) to the nearest white pixel.
*/

import java.io.*;
import java.util.*;

class Pixel{
    int x;
    int y;

    public Pixel(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Bitmap {
    public static int n;
    public static int m;
    public static LinkedList<Pixel> Queue;
    public static int[][] dist;
    public static boolean[][] white;
    public static void main(String[] args) throws IOException {
        
        System.setIn(new FileInputStream("test.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Queue = new LinkedList<>();
        white = new boolean[n+1][m+1];
        dist = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            String[] s = br.readLine().split("");
            for(int j=1;j<=m;j++){
                int c = Integer.parseInt(s[j-1]);
                if(c == 1){
                    Queue.add(new Pixel(i, j));
                    white[i][j] = true;
                }
            }
        }
        while(!Queue.isEmpty()){
            Pixel tmp = Queue.poll();
            int x = tmp.x;
            int y = tmp.y;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for(int i=0;i<4;i++){
                int xi = x+dx[i];
                int yi = y+dy[i];
                if(isBlack(xi, yi)){
                    dist[xi][yi] = dist[x][y]+1;
                    Queue.add(new Pixel(xi, yi));
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++)
                bw.write(dist[i][j] + " ");
            bw.write("\n");
        }
        bw.close();
    }
    public static boolean isBlack(int i, int j){
        if(i>0 && j>0 && i<=n && j<=m && !white[i][j] && dist[i][j]==0)
            return true;
        else
            return false;
    }
}