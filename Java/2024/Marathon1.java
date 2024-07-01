import java.io.*;
import java.util.StringTokenizer;

public class Marathon1 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N, distances[], total = 0, maxSkip = 0;
        Point checkpoints[];
        N = Integer.parseInt(st.nextToken());
        checkpoints = new Point[N];
        distances = new int[N - 1];

        st = new StringTokenizer(br.readLine(), " ");
        checkpoints[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            checkpoints[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            total += distances[i - 1] = getManhattanDistance(checkpoints[i - 1], checkpoints[i]);
        }

        for (int i = 1; i < N - 1; i++) {
            int skip = distances[i - 1] + distances[i] - getManhattanDistance(checkpoints[i - 1], checkpoints[i + 1]);
            maxSkip = Math.max(maxSkip, skip);
        }

        bw.append(Integer.toString(total - maxSkip));
        bw.flush();
        bw.close();
    }
    
    private static int getManhattanDistance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
