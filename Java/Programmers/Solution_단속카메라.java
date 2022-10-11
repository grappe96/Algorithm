package Java.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1, end, len = routes.length;
        
        Arrays.sort(routes, (i1, i2) -> {
            if(i1[0] == i2[0])
                return i1[1] - i2[1];
            return i1[0] - i2[0];
        });
        end = routes[0][1];
        
        for(int i=1;i<len;i++){
            if (routes[i][0] <= end)
                end = Math.min(end, routes[i][1]);
            else {
                answer++;
                end = routes[i][1];
            }
        }

        return answer;
    }
}