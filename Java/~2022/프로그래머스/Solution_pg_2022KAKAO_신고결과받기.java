import java.util.*;

class Solution_pg_2022KAKAO_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> idxMap = new HashMap<String, Integer>();
        Map<String, Set<Integer>> hMap = new HashMap<String, Set<Integer>>();
        int len = id_list.length, reportLen = report.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            idxMap.put(id_list[i], i);
            hMap.put(id_list[i], new HashSet<Integer>());
        }
        for (int i = 0; i < reportLen; i++) {
            String[] str = report[i].split(" ");
            hMap.get(str[1]).add(idxMap.get(str[0]));
        }

        for (int i = 0; i < len; i++) {
            Set<Integer> tmp = hMap.get(id_list[i]);
            if (tmp.size() >= k) {
                Iterator<Integer> iter = tmp.iterator();
                while (iter.hasNext())
                    answer[(int) iter.next()]++;
            }
        }
        
        return answer;
    }
}