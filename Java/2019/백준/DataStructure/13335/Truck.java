import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Truck {
    static class Set {
        int truckweight;
        int entertime;

        public Set(int tw, int et) {
            this.truckweight = tw;
            this.entertime = et;
        }
    }

    public static int solution(int truck_num, int bridge_length, int weight, int[] truck_weights) {
        Queue<Set> queue = new LinkedList<>();
        int time = 0, cross = 0, lastTruck = 0;
        while (lastTruck < truck_num) {
            time++;
            if (!queue.isEmpty())
                if (time - queue.peek().entertime == bridge_length)
                    cross -= queue.poll().truckweight;

            int nextTruck = truck_weights[lastTruck];
            if (cross + nextTruck <= weight) {
                queue.add(new Set(nextTruck, time));
                lastTruck++;
                cross += nextTruck;
            }
        }
        time += bridge_length;
        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);
        int L = Integer.parseInt(s[2]);
        s = br.readLine().split(" ");
        int[] truck_weights = new int[s.length];
        for(int i=0;i<truck_weights.length;i++)
            truck_weights[i] = Integer.parseInt(s[i]);
        System.out.println(solution(n, w, L, truck_weights));
    }
}