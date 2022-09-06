package study;

class Solution {
    public String solution(int[][] scores) {
        int n = scores.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int now = scores[i][i], avg = 0;
            int[] min = new int[2], max = new int[2];
            min[0] = min[1] = 101;
            max[0] = max[1] = -1;
            for(int j=0;j<n;j++){
                avg += scores[j][i];
                if(min[0] > scores[j][i])
                    min[0] = scores[j][i];
                else if(min[0] == scores[j][i])
                    min[1] = scores[j][i];
                if(max[0] < scores[j][i])
                    max[0] = scores[j][i];
                else if(max[0] == scores[j][i])
                    max[1] = scores[j][i]; 
            }
            int total = n;
            if((now == max[0] && max[0] != max[1])
              || (now == min[0] && min[0] != min[1])) {
                avg -= now;
                total--;
            }
            sb.append(getScore(avg/total));
        }
        return sb.toString();
    }
    private static String getScore(int avg){
        if(avg >= 90)
            return "A";
        else if(avg >= 80)
            return "B";
        else if(avg >= 70)
            return "C";
        else if(avg >= 50)
            return "D";
        else
            return "F";
    }
}