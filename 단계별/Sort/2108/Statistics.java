/*
문제

수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 
통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력

첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 
그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력

첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
둘째 줄에는 중앙값을 출력한다.
셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
넷째 줄에는 범위를 출력한다.
*/

import java.util.Scanner;

public class Statistics {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[8001];
        int[] second = new int[2];
        int tmp, mode=0, median=0, median_chk=0, range=0, min=-1, max=0;
        double average = 0.0;
        for(int i=0;i<N;i++){
            tmp = sc.nextInt();
            num[tmp+4000]++;
        }
        for(int i=0;i<=8000;i++){
            if (num[i] != 0){
                max = i;
                if (min == -1)
                    min = i;

                average += (i-4000)*num[i];

                if (num[i] > num[mode]){
                    second[0] = mode = i;
                    second[1] = -1;
                }
                else if (num[i] == num[mode]){
                    if (second[1] == -1){
                        second[1] = second[0];
                        second[0] = mode = i;
                    }
                }

                if (median_chk < (N/2+1))
                    median_chk += num[i];
                if (median_chk >= (N/2+1) && median == 0){
                    median = i-4000;
                    if (N%2 == 0) {
                        if(num[i] == 1){
                            for (int j = i-1;j>0;j--){
                                if (num[j] != 0){
                                    median += j-4000;
                                    break;
                                }
                            }
                            median /= 2;
                        }
                    }
                }
            }
        }
        range = max - min;
        mode -= 4000;
        average /= (double)N;
        System.out.println(Math.round(average));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
        sc.close();
    }
}